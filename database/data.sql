INSERT INTO Course (name, description, duration_days, is_on_site, is_online, price) VALUES
('Java Débutant',
 'Bases du langage Java et programmation orientée objet',
 5, TRUE, TRUE, 1200.00),

('Java Avancé',
 'Approfondissement Java, collections, streams et bonnes pratiques',
 4, TRUE, FALSE, 1500.00),

('UML et Modélisation',
 'Diagrammes UML : cas d’utilisation, classes et séquences',
 3, FALSE, TRUE, 900.00),

('Base de données relationnelles',
 'Conception MCD, MLD et SQL avec MySQL/MariaDB',
 4, TRUE, TRUE, 1100.00),

('Spring Boot',
 'Création d’API REST avec Spring Boot',
 5, FALSE, TRUE, 1800.00),

('Git et gestion de versions',
 'Utilisation de Git et GitHub en équipe',
 2, TRUE, TRUE, 600.00),
 
 ('Python Débutant',
 'Introduction au langage Python et aux bases de la programmation',
 5, TRUE, TRUE, 1100.00),

('Python Avancé',
 'Programmation avancée, modules, virtualenv et bonnes pratiques',
 4, FALSE, TRUE, 1400.00),

('JavaScript Fondamentaux',
 'Bases de JavaScript pour le développement web',
 3, TRUE, TRUE, 900.00),

('Développement Web HTML/CSS',
 'Création de pages web avec HTML5 et CSS3',
 3, TRUE, TRUE, 800.00),

('React.js',
 'Développement d’interfaces web dynamiques avec React',
 5, FALSE, TRUE, 1700.00),

('Node.js',
 'Création d’API backend avec Node.js et Express',
 4, FALSE, TRUE, 1600.00),

('Sécurité informatique',
 'Bases de la cybersécurité et des bonnes pratiques',
 3, TRUE, FALSE, 1300.00),

('Docker',
 'Conteneurisation d’applications avec Docker',
 2, TRUE, TRUE, 700.00),

('DevOps Fondamentaux',
 'Introduction aux pratiques DevOps et CI/CD',
 3, FALSE, TRUE, 1200.00),

('Tests logiciels',
 'Tests unitaires, d’intégration et automatisés',
 3, TRUE, TRUE, 1000.00);

 
INSERT INTO person (firstname, lastname) VALUES
('Lucas', 'Martin'),
('Emma', 'Durand'),
('Noah', 'Petit'),
('Léa', 'Moreau'),
('Hugo', 'Lefevre'),
('Chloé', 'Garcia'),
('Nathan', 'Roux'),
('Inès', 'Fournier'),
('Ethan', 'Bernard'),
('Sarah', 'Dubois');


INSERT INTO user_ (password, id_person) VALUES
('userpass1', 1),
('userpass2', 2),
('userpass3', 3),
('userpass4', 4),
('userpass5', 5);


INSERT INTO customer (address, email, phone_number, id_person) VALUES
('12 rue de Paris, Lyon', 'chloe.garcia@mail.com', '0612345678', 6),
('5 avenue Victor Hugo, Paris', 'nathan.roux@mail.com', '0623456789', 7),
('18 boulevard Sud, Marseille', 'ines.fournier@mail.com', '0634567890', 8),
('9 rue des Lilas, Lille', 'ethan.bernard@mail.com', '0645678901', 9),
('22 place Bellecour, Lyon', 'sarah.dubois@mail.com', '0656789012', 10);