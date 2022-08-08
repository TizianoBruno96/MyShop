# MyShop
Progetto di Tiziano Bruno e Alessio Gravante per unisalento
Una grande catena di mobili e prodotti per la casa vuole creare il sistema MyShop da installare su totem all'interno dei propri punti vendita per migliorare l'esperienza di acquisto della clientela. Il sistema deve avere le seguenti caratteristiche, suddivise per profili di utenza:

- 	Amministratore: gestisce il catalogo di MyShop inserendo, modificando e cancellando articoli. Gli articoli del catalogo possono essere prodotti e servizi. I prodotti sono suddivisi in categorie (mobili, illuminazione, tessili) e	sottocategorie (cucina, soggiorno, camera, tappeti, tende, lampadari, lampade da esterno). I prodotti possono essere composti da altri prodotti, vendibili singolarmente. Per ogni prodotto, l'amministratore definisce il costo, la collocazione nel magazzino self-service in termini di numero di corsia e numero di scaffale. Per ogni prodotto l'amministratore definisce il produttore (nome, sito web, città, nazione). I servizi sono suddivisi in categorie (montaggio, trasporto). Per ogni servizio l'amministratore definisce il costo. L'amministratore può creare liberamente nuovi prodotti, nuove composizioni di prodotti, nuove categorie e sottocategorie, nuovi produttori, nuovi servizi, senza che sia necessaria alcuna modifica alla base di dati e al software. L'amministratore crea più punti vendita sul territorio e decide quali articoli possono vendere. L'amministrazione crea un utente manager di ogni punto vendita.

- 	Manager: si autentica al sistema per gestire la disponibilità di articoli a magazzino e rifornire periodicamente il magazzino stesso. Il manager può inviare messaggi di e-mail agli utenti acquirenti registrati nel suo punto vendita. Il manager può rispondere ai commenti lasciati dagli utenti che hanno fatto acquisti nel suo punto vendita. Il manager gestisce (disabilita, cancella) gli utenti acquirenti registrati nel suo punto vendita.

- 	Utente acquirente: si autentica a un qualunque punto vendita del sistema per cercare articoli, consultare i relativi costi e la disponibilità. L'aquirente può definire liste di acquisto inserendo gli articoli di interesse presenti nel catalogo di MyShop. Quando soffisfatto, l'aquirente può generare la lista di acquisto in formato pdf in modo che il sistema gliela invii per posta elettronica e la possa usare come promemoria per prelevare gli articoli dal magazzino self-service. All'atto del pagamento, l'acquirente mostra la lista di acquisto alla cassa, il sistema ne aggiorna lo stato in "pagata". L'aquirente può salvare le liste di acquisto per successive visite ai punti vendita o come base per nuovi acquisti. L'aquirente può prenotare gli articoli di suo interesse non disponibili a magazzino; tali articoli gli saranno recapitati al punto vendita al quale si è registrato. L'acquirente può lasciare feedback sotto forma di commenti e/o indici di gradimento esclusivamente per gli articoli acquistati.

- 	Utente guest: naviga il catalogo di MyShop prendendo visione degli articoli offerti con i relativi costi e disponibilità. Se interessato, si registra fornendo dati di profilo (nome, cognome, e-mail, telefono, età, residenza, professione).

Lo schema dei dati di un articolo deve contenere almeno i seguenti dati (possono essere fatte liberamente estensioni):
- 	Il nome dell'articolo;
- 	Una o più immagini rappresentative;
- 	Una descrizione (max 255 caratteri);
-	Uno o più prodotti contenuti (solo per i prodotti, non per i servizi);
-	Il produttore (per i prodotti) o fornitore del servizio (per i servizi);
-	Il costo in euro;
- 	La posizione del prodotto nel magazzino come numero corsia e numero scaffale (solo per i prodotti);
-	Zero o più commenti (max 150 caratteri);
- 	Zero o più espressioni di gradimento (da 1 a 5, dove 1 è scarso e 5 è eccellente);

INDICAZIONI PER LO SVOLGIMENTO
Il sistema deve essere realizzato con il linguaggio di sviluppo Java, adottando l'architettura software e i design pattern analizzati durante il corso. I dati dovranno essere memorizzati in una base di dati relazionale MySQL. Si deve adottare un processo di sviluppo agile Scrum e documentare il procedimento di lavoro adottato. Si devono realizzare gli unit test delle contenute classi nel package DAO. L'elaborato software può essere svolto in gruppi di due studenti (due studenti è il numero massimo consentito) o singolarmente.
Due giorni solari prima dell'appello d'esame orale devono essere inviati al docente per e-mail come link a un drive la documentazione di progetto in formato PDF e il software realizzato, in un unico file compresso in formato ZIP. I software consegnati saranno sottoposti a test di similarità, utilizzando strumenti automatici (tipo DIFF o più evoluti).
Il giorno dell'esame orale deve: (1) essere fornita la documentazione in digitale. (2) eseguita una dimostrazione interattiva del sistema software. A ogni componente del gruppo, singolarmente, sarà richiesto di modificare il software utilizzando l'ambiente di sviluppo, implementando nuovi requisiti forniti dal docente al momento. La documentazione deve essere composta da un unico documento con frontespizio e indice, contenente: (1) analisi dei requisiti, (2) progettazione UML dell'architettura software, (3) esplicita indicazione dei design pattern adottati, (4) progettazione concettuale e logica della base dati, (5) esiti degli unit test eseguiti, (6) Scrum "sprint backing" e "burndown chart".
