import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import java.io.*;

/**
 * Ein einfacher Sound-Player. Erzeugen Sie eine Instanz dieser
 * Klasse zum Starten.
 * 
 * Der Sound-Player fungiert als Schnittstelle zu der Musiksammlung-Klasse
 * aus Kapitel 4.
 * 
 * @author Michael Kölling und David J Barnes 
 * @version 1.0
 */
public class MusikPlayerGUI extends JFrame
{
    private static final String VERSION = "Version 1.0";
    private static final String AUDIO_VERZEICHNIS = "../audio";
    
    private JList<String> dateiliste;
    private JSlider schieberegler;
    private JLabel infoLabel;
    private Musiksammlung sammlung;
    // ein Player für die Musik-Tracks
    private MusikPlayer player;
    // die aktuelle Track-Liste
    private List<Track> trackListe;

    /**
     * Main-Methode zum Starten von der Kommandozeile.
     */
    public static void main(String[] args)
    {
        MusikPlayerGUI gui = new MusikPlayerGUI();
    }
    
    /**
     * Erzeuge einen Sound-Player und zeige seine GUI
     * auf dem Bildschirm an.
     */
    public MusikPlayerGUI()
    {
        super("Musik-Player");
        sammlung = new Musiksammlung(AUDIO_VERZEICHNIS);
        player = new MusikPlayer();
        
        fensterErzeugen();
    }

    /**
     * Spiele die Sound-Datei, die aktuell in der Dateiliste selektiert ist.
     * Wenn keine Datei selektiert ist oder die selektierte Datei keine
     * Sound-Datei ist, tue nichts.
     */
    private void start()
    {
        int index = dateiliste.getSelectedIndex();
        if(index >= 0 && index < trackListe.size()) {
            schieberegler.setValue(0);
            player.starteAbspielen(trackListe.get(index).gibDateiname());
        }
    }
    
    /**
     * Stoppe die aktuell gespielten Sound-Datei (falls eine gespielt wird).
     */
    private void stop()
    {
        player.stop();
    }

    /**
     * Halte die aktuell gespielte Sound-Datei an(falls eine gespielt wird).
     */
    private void pause()
    {
        player.pause();
    }

    /**
     * Spiele einen zuvor angehaltene Sound-Datei weiter ab.
     */
    private void weiter()
    {
        player.weiter();
    }

    /**
     * Zeige Informationen über eine selektierte Sound-Datei (Name und L�nge).
     * @param text  der anzuzeigende Text
     */
    private void zeigeDateiInfo(String text)
    {
        infoLabel.setText(text);
    }
    
    /**
     * 'Beenden'-Funktion: Beenden der Anwendung.
     */
    private void beenden()
    {
        System.exit(0);
    }
    
    
    /**
     * 'Info'-Funktion: Zeige Informationen zur Anwendung.
     */
    private void zeigeInfo()
    {
        JOptionPane.showMessageDialog(this, 
                    "Musik-Player\n" + VERSION,
                    "Info zum Musik-Player", 
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Setze die Reihenfolge für die Track-Liste.
     * @param reihenfolge  die zu verwendende Reihenfolge
     */
    private void setzeListenReihenfolge(String reihenfolge)
    {
        trackListe = sammlung.sortiereNachFeld(reihenfolge);
        String[] tracks = gibTrackAnzeigeliste(trackListe);
        dateiliste.setListData(tracks);
    }
    
    /**
     * Liefere eine für die Anzeige aufbereitete Version der Track-Liste .
     * @param trackListe  die Liste der anzuzeigenden Tracks
     * @return            die Tracks im Anzeigeformat
     */
    private String[] gibTrackAnzeigeliste(List<Track> trackListe)
    {
        int anzahlTracks = trackListe.size();
        String[] tracks = new String[anzahlTracks];
        for(int i = 0; i < anzahlTracks; i++) {
            String[] felder = trackListe.get(i).gibFelder();
            StringBuilder auflistung = new StringBuilder();
            for(String feld : felder) {
                auflistung.append(feld);
                auflistung.append(" ");
            }
            tracks[i] = auflistung.toString().trim();
        }
        return tracks;
    }
    
    
    // ---- Swing-Anteil zum Erzeugen des Fensters mit allen Komponenten ----
    
    /**
     * Konstruktion der kompletten grafischen Benutzungsoberfläche.
     */
    private void fensterErzeugen()
    {
        // Sicherstellen, dass die Anwendung beendet wird, wenn der
        // Benutzer das Fenster schließt
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel contentPane = (JPanel)getContentPane();
        contentPane.setBorder(new EmptyBorder(6, 10, 10, 10));

        menuezeileErzeugen();
        
        // Ein Layout mit hübschen Abständen definieren
        contentPane.setLayout(new BorderLayout(8, 8));

        // Die Combo-Box links mit Scrollbalken erzeugen
        JPanel linkerBereich = new JPanel();
        {
            linkerBereich.setLayout(new BorderLayout(8, 8));

            // Komponenten für die Sortierung der Track-Liste einrichten.
            JPanel sortierPanel = new JPanel();
            sortierPanel.setLayout(new BorderLayout());
            sortierPanel.add(new JLabel("Sortiere nach:"), BorderLayout.NORTH);
            
            // Hole die Liste der Feldnamen für die Sortierung.
            String[] reihenfolge = Track.FELDER;
            
            // Die Combo-Box erzeugen
            JComboBox<String> formatListe = new JComboBox<>(reihenfolge);
            formatListe.addActionListener(e -> {
                int index = formatListe.getSelectedIndex();
                if(index >= 0) {
                    String selectedOrder = formatListe.getItemAt(index);
                    setzeListenReihenfolge(selectedOrder);
                }
            });
            sortierPanel.add(formatListe, BorderLayout.CENTER);
    
            linkerBereich.add(sortierPanel, BorderLayout.NORTH);
    
            // Eine scrollbare Liste der Dateinamen erzeugen
            dateiliste = new JList<>();
            dateiliste.setForeground(new Color(140,171,226));
            dateiliste.setBackground(new Color(0,0,0));
            dateiliste.setSelectionBackground(new Color(87,49,134));
            dateiliste.setSelectionForeground(new Color(140,171,226));
            JScrollPane scrollPane = new JScrollPane(dateiliste);
            scrollPane.setColumnHeaderView(new JLabel("Audio-Dateien"));
            linkerBereich.add(scrollPane, BorderLayout.CENTER);
            
            // die anfängliche Auflistung erstellen.
            setzeListenReihenfolge(reihenfolge[0]);
        }
        contentPane.add(linkerBereich, BorderLayout.CENTER);

        // Mittelbereich mit Bild-Label, Text-Label und Schieberegler erzeugen
        JPanel mittelbereich = new JPanel();
        {
            mittelbereich.setLayout(new BorderLayout(8, 8));
    
            JLabel bildLabel = new JLabel(new ImageIcon("title.jpg"));
            mittelbereich.add(bildLabel, BorderLayout.NORTH);
            mittelbereich.setBackground(Color.BLACK);

            infoLabel = new JLabel("  ");
            infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            infoLabel.setForeground(new Color(140,171,226));
            mittelbereich.add(infoLabel, BorderLayout.CENTER);

            schieberegler = new JSlider(0, 100, 0);
            TitledBorder border = new TitledBorder("Positionieren");
            border.setTitleColor(Color.white);
            schieberegler.setBorder(new CompoundBorder(new EmptyBorder(6, 10, 10, 10), border));
            // einen Rumpf für den ChangeListener-Lambda liefern, 
            // um auf Veränderungen des Reglers zu reagieren
            schieberegler.addChangeListener(e -> { });
            schieberegler.setBackground(Color.BLACK);
            schieberegler.setMajorTickSpacing(25);
            schieberegler.setPaintTicks(true);
            mittelbereich.add(schieberegler, BorderLayout.SOUTH);
        }
        contentPane.add(mittelbereich, BorderLayout.EAST);

        // die Tastenreihe mit den Tasten erzeugen
        JPanel tastenreihe = new JPanel();
        {
            tastenreihe.setLayout(new GridLayout(1, 0));
  
            JButton taste = new JButton("Start");
            taste.addActionListener(e -> start());
            tastenreihe.add(taste);
            
            taste = new JButton("Stop");
            taste.addActionListener(e -> stop());
            tastenreihe.add(taste);
    
            taste = new JButton("Pause");
            taste.addActionListener(e -> pause());
            tastenreihe.add(taste);
            
            taste = new JButton("Weiter");
            taste.addActionListener(e -> weiter());
            tastenreihe.add(taste);
        }
        
        contentPane.add(tastenreihe, BorderLayout.NORTH);

        // Aufbau abgeschlossen - Komponenten arrangieren lassen
        pack();
        
        // Das Fenster in der Mitte des Bildschirms platzieren und anzeigen lassen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(d.width/2 - getWidth()/2, d.height/2 - getHeight()/2);
        setVisible(true);
    }
    
    /**
     * Erzeugen der Menüzeile.
     */
    private void menuezeileErzeugen()
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menuezeile = new JMenuBar();
        setJMenuBar(menuezeile);
        
        JMenu menue;
        JMenuItem eintrag;
        
        // Das Datei-Menü erzeugen
        menue = new JMenu("Datei");
        menuezeile.add(menue);
        
        eintrag = new JMenuItem("Beenden");
            eintrag.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            eintrag.addActionListener(e -> beenden());
        menue.add(eintrag);

        // Das Hilfe-Menü erzeugen
        menue = new JMenu("Hilfe");
        menuezeile.add(menue);
        
        eintrag = new JMenuItem("Info...");
            eintrag.addActionListener(e -> zeigeInfo());
        menue.add(eintrag);
    }
}
