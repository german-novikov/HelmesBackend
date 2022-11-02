-- CREATE TABLE sector (
--     value BIGINT PRIMARY KEY NOT NULL,
--     name VARCHAR,
--     parent BIGINT
-- );
--
-- CREATE TABLE user_select(
--     id SERIAL NOT NULL PRIMARY KEY,
--     name VARCHAR NOT NULL,
--     sectors JSON NOT NULL,
--     agree_with_terms BOOLEAN NOT NULL DEFAULT 'false'::Boolean
-- );

INSERT INTO sector VALUES
    (1, 'Manufacturing', 0),
    (3, 'Other', 0),
    (2, 'Service', 0),
    (19, 'Construction materials', 1),
    (18, 'Electronics and Optics', 1),
    (6, 'Food and Beverage', 1),
    (13, 'Furniture', 1),
    (12, 'Machinery', 1),
    (11, 'Metalworking', 1),
    (9, 'Plastic and Rubber', 1),
    (5, 'Printing', 1),
    (7, 'Textile and Clothing', 1),
    (8, 'Wood', 1),
    (37, 'Creative industries', 3),
    (29, 'Energy technology', 3),
    (33, 'Environment', 3),
    (25, 'Business services', 2),
    (35, 'Engineering', 2),
    (28, 'Information Technology and Telecommunications', 2),
    (22, 'Tourism', 2),
    (141, 'Translation services', 2),
    (21, 'Transport and Logistics', 2),
    (342, 'Bakery &amp; confectionery products', 6),
    (43, 'Beverages', 6),
    (42, 'Fish &amp; fish products', 6),
    (40, 'Meat &amp; meat products', 6),
    (39, 'Milk &amp; dairy products', 6),
    (437, 'Other', 6),
    (378, 'Sweets &amp; snack food', 6),
    (389, 'Bathroom/sauna', 13),
    (385, 'Bedroom', 13),
    (390, 'Children’s room', 13),
    (98, 'Kitchen', 13),
    (101, 'Living room', 13),
    (392, 'Office', 13),
    (394, 'Other (Furniture)', 13),
    (341, 'Outdoor', 13),
    (99, 'Project furniture', 13),
    (94, 'Machinery components', 12),
    (91, 'Machinery equipment/tools', 1),
    (224, 'Manufacture of machinery', 1),
    (97, 'Maritime', 12),
    (271, 'Aluminium and steel workboats', 12),
    (269, 'Boat/Yacht building', 12),
    (230, 'Ship repair and conversion', 12),
    (93, 'Metal structures', 12),
    (508, 'Other', 12),
    (227, 'Repair and maintenance service', 12),
    (67, 'Construction of metal structures', 11),
    (263, 'Houses and buildings', 11),
    (267, 'Metal products', 11),
    (542, 'Metal works', 11),
    (75, 'CNC-machining', 11),
    (62, 'Forgings, Fasteners', 11),
    (69, 'Gas, Plasma, Laser cutting', 11),
    (66, 'MIG, TIG, Aluminum welding', 11),
    (54, 'Packaging', 9),
    (556, 'Plastic goods', 9),
    (559, 'Plastic processing technology', 9),
    (555, 'Blowing', 9),
    (57, 'Moulding', 9),
    (53, 'Plastics welding and processing', 9),
    (560, 'Plastic profiles', 9),
    (148, 'Advertising', 5),
    (150, 'Book/Periodicals printing', 5),
    (145, 'Labelling and packaging printing', 5),
    (44, 'Clothing', 7),
    (45, 'Textile', 7),
    (337, 'Other (Wood)', 8),
    (51, 'Wooden building materials', 8),
    (47, 'Wooden houses', 8),
    (581, 'Data processing, Web portals, E-marketing', 1),
    (576, 'Programming, Consultancy', 1),
    (121, 'Software, Hardware', 1),
    (122, 'Telecommunications', 1),
    (111, 'Air', 21),
    (114, 'Rail', 21),
    (112, 'Road', 21),
    (113, 'Water', 21);
