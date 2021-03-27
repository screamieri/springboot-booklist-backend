
INSERT INTO book (id, author, isbn, publisher, title, genre, publish_date, description) VALUES
	(4, 'Joanne K. Rowling', '8831003380', 'Pottermore Publishing', 'Harry Potter e la pietra filosofale', 'Fiction', '2020-01-23', 'Harry Potter è un predestinato: ha una cicatrice a forma di saetta sulla fronte e provoca strani fenomeni, come quello di farsi ricrescere in una notte i capelli inesorabilmente tagliati dai perfidi zii. Ma solo in occasione del suo undicesimo compleanno gli si rivelano la sua natura e il suo destino, e il mondo misterioso cui di diritto appartiene. Nello scatenato universo fantastico della Rowling, popolato da gufi portalettere, scope volanti, caramelle al gusto di cavolini di Bruxelles, ritratti che scappano, la magia si presenta come la vera vita e strega anche il lettore allontanandolo dal nostro mondo che gli apparirà monotono e privo di sorprese. Il risveglio dalla lettura lo lascerà pieno di nostalgia, ma ancora illuminato dai riflessi di questo lussureggiante fuoco d’artificio.'),
	(6, 'Joanne K. Rowling', '1781102120', 'Pottermore Publishing', 'Harry Potter e la Camera dei Segreti', 'Fiction', '2015-12-08', 'A Hogwarts il nuovo anno scolastico s’inaugura all’insegna di fatti inquietanti: strane voci riecheggiano nei corridoi e Ginny sparisce nel nulla. Un antico mistero si nasconde nelle profondità del castello e incombe ora sulla scuola, toccherà a Harry, Ron e Hermione risolvere l’enigma che si cela nella tenebrosa Camera dei Segreti...');


INSERT INTO user (id, email, first_name, last_name, password) VALUES
	(7, 'testAndrea@test.it', 'Andrea', 'Caldarelli', 'test'),
	(1, 'testDavide@test.it', 'Davide', 'Verdini', 'test');


INSERT INTO user_book (book_id, user_id) VALUES
    (4, 7),
    (6, 7),
    (6, 1);