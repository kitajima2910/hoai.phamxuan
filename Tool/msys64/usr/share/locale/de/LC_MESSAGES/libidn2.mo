��    )      d  ;   �      �  �   �  �   u  �   .  c   �     1     J  R  W  N   �  &   �  O         p  #   ~  !   �  *   �  D   �  @   4	  %   u	  &   �	  &   �	  (   �	     
     -
     9
  (   G
  '   p
  4   �
  4   �
  &     /   )  /   Y  7   �  -   �  %   �  %     "   ;     ^  .   t  #   �  '   �     �  �  �    �  �   �  �   �  p   j  #   �     �  �    ^   �  5     h   T     �  &   �  7   �  7   /  R   g  L   �  4     '   <  '   d  5   �  !   �     �     �  /     0   7  :   h  :   �  -   �  2     2   ?  D   r  >   �  1   �  2   (  1   [  !   �  >   �  ,   �  ;        W                	   (                                 "          
                                     &                  '                                          #          !          )             %   $          --usestd3asciirules   Enable STD3 ASCII rules
      --no-alabelroundtrip  Disable A-label roundtrip for lookups
      --debug               Print debugging information
      --quiet               Silent operation
   -T, --tr46t               Enable TR46 transitional processing
  -N, --tr46nt              Enable TR46 non-transitional processing
      --no-tr46             Disable TR46 processing
   -d, --decode              Decode (punycode) domain name
  -l, --lookup              Lookup domain name (default)
  -r, --register            Register label
   -h, --help                Print help and exit
  -V, --version             Print version and exit
 A-label roundtrip failed Charset: %s
 Command line interface to the Libidn2 implementation of IDNA2008.

All strings are expected to be encoded in the locale charset.

To process a string that starts with `-', for example `-foo', use `--'
to signal the end of parameters, as in `idn2 --quiet -- -foo'.

Mandatory arguments to long options are mandatory for short options too.
 Internationalized Domain Name (IDNA2008) convert STRINGS, or standard input.

 Try `%s --help' for more information.
 Type each input string on a line by itself, terminated by a newline character.
 Unknown error Usage: %s [OPTION]... [STRINGS]...
 could not convert string to UTF-8 could not determine locale encoding format domain label has character forbidden in non-transitional mode (TR46) domain label has character forbidden in transitional mode (TR46) domain label has forbidden dot (TR46) domain label longer than 63 characters domain name longer than 255 characters input A-label and U-label does not match input A-label is not valid input error out of memory punycode conversion resulted in overflow punycode encoded data will be too large string contains a context-j character with null rule string contains a context-o character with null rule string contains a disallowed character string contains a forbidden context-j character string contains a forbidden context-o character string contains a forbidden leading combining character string contains forbidden two hyphens pattern string contains invalid punycode data string contains unassigned code point string could not be NFC normalized string encoding error string has forbidden bi-directional properties string is not in Unicode NFC format string start/ends with forbidden hyphen success Project-Id-Version: libidn2 2.3.1
Report-Msgid-Bugs-To: bug-libidn2@gnu.org
PO-Revision-Date: 2021-05-13 17:47+0200
Last-Translator: Mario Blättermann <mario.blaettermann@gmail.com>
Language-Team: German <translation-team-de@lists.sourceforge.net>
Language: de
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
X-Bugs: Report translation errors to the Language-Team address.
Plural-Forms: nplurals=2; plural=(n != 1)
X-Generator: Lokalize 21.04.0
       --usestd3asciirules   STD3-ASCII-Regeln aktivieren
      --no-alabelroundtrip  A-Label-Rundlauf für Nachschlagungen                              deaktivieren
      --debug               Debugging-Informationen ausgeben
      --quiet               Still arbeiten
   -T, --tr46t               Transitionale TR46-Verarbeitung aktivieren
  -N, --tr46nt              Nicht-transitionale TR46-Verarbeitung aktivieren
      --no-tr46             TR46-Verarbeitung deaktivieren
   -d, --decode              Domainname dekodieren (Punycode)
  -l, --lookup              Domainname nachschlagen (Standard)
  -r, --register            Label registrieren
   -h, --help                Hilfe ausgeben und beenden
  -V, --version             Version ausgeben und beenden
 A-Label-Rundlauf ist fehlgeschlagen Zeichensatz: %s«
 Befehlszeilenprogramm für die Libidn2-Implementierung nach IDNA2008.

Alle Zeichenketten werden so codiert erwartet, wie es der Zeichensatz der Locale
angibt.

Um einen String zu verarbeiten, der mit »-« beginnt (zum Beispiel »-foo«),
können Sie das Ende der Optionen mit »--« kennzeichnen.
Zum Beispiel: »idn2 --quiet -- -foo«.

Notwendige Argumente für die langen Optionen gelten genau so für die
kurzen Optionen.
 Internationalized Domain Name (IDNA2008) konvertiert Zeichenketten oder die Standardeingabe.

 Versuchen Sie »%s --help« für mehr Informationen.
 Geben Sie jede Eingabezeichenkette in einer eigenen Zeile ein, durch einen Zeilenumbruch abgeschlossen.
 Unbekannter Fehler Aufruf: %s [OPTION] … [STRINGS] …
 Zeichenkette konnte nicht nach UTF-8 konvertiert werden Kodierungsformat der Locale konnte nicht erkannt werden Domain-Label enthält ein im nicht-transitionalen Modus verbotenes Zeichen (TR 46) Domain-Label enthält ein im transitionalen Modus verbotenes Zeichen (TR 46) Domain-Label enthält einen verbotenen Punkt (TR 46) Domain-Label ist länger als 63 Zeichen Domain-Name ist länger als 255 Zeichen A-Label der Eingabe und U-Label passen nicht zusammen A-Label der Eingabe ist ungültig Eingabefehler Nicht genug Speicher Punycode-Umwandlung verursachte einen Überlauf Mit Punycode kodierte Daten werden zu groß sein Zeichenkette enthält ein Context-j-Zeichen mit Null-Regel Zeichenkette enthält ein Context-o-Zeichen mit Null-Regel Zeichenkette enthält ein unerlaubtes Zeichen Zeichenkette enthält verbotenes Context-j-Zeichen Zeichenkette enthält verbotenes Context-o-Zeichen Zeichenkette enthält verbotenes vorangestelltes Kombinationszeichen Zeichenkette enthält verbotenes Muster aus zwei Bindestrichen Zeichenkette enthält unzulässige Punycode-Daten Zeichenkette enthält nicht zugewiesenen Codepoint Zeichenkette konnte nicht NFC-normalisiert werden Kodierungsfehler der Zeichenkette Zeichenkette hat widersprüchliche bidirektional-Eigenschaften Zeichenkette ist nicht im Unicode-NFC-Format Zeichenkette beginnt/endet mit einem verbotenen Bindestrich Erfolg 