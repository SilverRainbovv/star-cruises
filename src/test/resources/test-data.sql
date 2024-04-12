insert into users (id, role, email, password)
values (101, 'CLIENT', 'vadimdidenko@gmail.com', '{noop}123'),
       (102, 'CLIENT', 'vadimdidenko1@gmail.com', '{noop}123'),
       (103, 'CLIENT', 'siacobini2@yale.edu', '{noop}123'),
       (104, 'CLIENT', 'fsolly3@yale.edu', '{noop}123'),
       (105, 'CLIENT', 'mfoulds4@lycos.com', '{noop}123'),
       (106, 'CLIENT', 'flofts5@histats.com', '{noop}123'),
       (107, 'CLIENT', 'cmuglestone6@telegraph.co.uk', '{noop}123'),
       (108, 'CLIENT', 'ecatonne7@state.gov', '{noop}123'),
       (109, 'CLIENT', 'lfaulkes8@51.la', '{noop}123'),
       (110, 'CLIENT', 'hwatkinson9@cam.ac.uk', '{noop}123'),
       (111, 'CLIENT', 'potteea@php.net', '{noop}123'),
       (112, 'CLIENT', 'epedrolb@photobucket.com', '{noop}123'),
       (113, 'CLIENT', 'donraetc@upenn.edu', '{noop}123'),
       (114, 'CLIENT', 'rhaibeld@arstechnica.com', '{noop}123'),
       (115, 'CLIENT', 'magneaue@desdev.cn', '{noop}123'),
       (116, 'CLIENT', 'bryallf@weibo.com', '{noop}123'),
       (117, 'CLIENT', 'smilroyg@google.ca', '{noop}123'),
       (118, 'CLIENT', 'tmatschkeh@google.co.uk', '{noop}123'),
       (119, 'ADMIN', 'cloughi@ask.com', '{noop}123'),
       (120, 'CLIENT', 'tfidginj@biglobe.ne.jp', '{noop}123');

insert into client (id, user_id, firstname, lastname, birth_date)
values (101, 101, 'John', 'Doe', '1984-04-16'),
       (102, 102, 'Emmit', 'Mc Combe', '1971-08-26'),
       (103, 103, 'Garrett', 'Dawidsohn', '1994-12-08'),
       (104, 104, 'Archambault', 'Dinneges', '1969-01-02'),
       (105, 105, 'Sidoney', 'Hadland', '1970-12-13'),
       (106, 106, 'Kali', 'Sertin', '1983-01-28'),
       (107, 107, 'Winnifred', 'Carefull', '1991-08-02'),
       (108, 108, 'Hubie', 'Delieu', '1987-01-11'),
       (109, 109, 'Linell', 'Foote', '1976-07-11'),
       (110, 110, 'Arlen', 'Pre', '1971-11-24'),
       (111, 111, 'Linea', 'Colthard', '1994-09-01'),
       (112, 112, 'Broderic', 'Renac', '1997-02-18'),
       (113, 113, 'Harald', 'Smiz', '1971-03-15'),
       (114, 114, 'Blake', 'Rhule', '1988-11-08'),
       (115, 115, 'Alleyn', 'Craighall', '1974-07-21'),
       (116, 116, 'Catharine', 'Roycraft', '1970-03-03'),
       (117, 117, 'Jdavie', 'Valentim', '1971-03-12'),
       (118, 118, 'Merrili', 'Dimitrov', '1985-07-11'),
       (119, 119, 'Moselle', 'Noads', '1981-07-11'),
       (120, 120, 'Cory', 'Roalfe', '1997-11-29');

insert into ship (id, name)
values (101, 'Sidonia'),
       (102, 'Andromeda'),
       (103, 'Navius'),
       (104, 'Sirius'),
       (105, 'Mega Transporter'),
       (106, 'Ryan and girls'),
       (107, '404 Not Found'),
       (108, 'Good Boi'),
       (109, '2B or not 2B'),
       (110, 'Asylum');

insert into seat (price, id, ship_id, number, vacancy, seat_group, seat_class, number_of_persons)
values (1000, 1001, 101, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1002, 101, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1003, 101, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1004, 101, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1005, 101, 5, 'VACANT', 1, 'INTERIOR', 2),
       (2000, 1006, 101, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (2000, 1007, 101, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (2000, 1008, 101, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (2000, 1009, 101, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (2000, 1010, 101, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1011, 101, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1012, 101, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1013, 101, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1014, 101, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1015, 101, 15, 'VACANT', 3, 'BALCONY', 3),
       (3000, 1016, 102, 1, 'VACANT', 1, 'INTERIOR', 2),
       (3000, 1017, 102, 2, 'VACANT', 1, 'INTERIOR', 2),
       (3000, 1018, 102, 3, 'VACANT', 1, 'INTERIOR', 2),
       (3000, 1019, 102, 4, 'VACANT', 1, 'INTERIOR', 2),
       (3000, 1020, 102, 5, 'VACANT', 1, 'INTERIOR', 2),
       (3000, 1021, 102, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (3000, 1022, 102, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (3000, 1023, 102, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (3000, 1024, 102, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (3000, 1025, 102, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1026, 102, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1027, 102, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1028, 102, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1029, 102, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1030, 102, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1031, 103, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1032, 103, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1033, 103, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1034, 103, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1035, 103, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1036, 103, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1037, 103, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1038, 103, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1039, 103, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1040, 103, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1041, 103, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1042, 103, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1043, 103, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1044, 103, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1045, 103, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1046, 104, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1047, 104, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1048, 104, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1049, 104, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1050, 104, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1051, 104, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1052, 104, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1053, 104, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1054, 104, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1055, 104, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1056, 104, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1057, 104, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1058, 104, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1059, 104, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1060, 104, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1061, 105, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1062, 105, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1063, 105, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1064, 105, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1065, 105, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1066, 105, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1067, 105, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1068, 105, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1069, 105, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1070, 105, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1071, 105, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1072, 105, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1073, 105, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1074, 105, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1075, 105, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1076, 106, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1077, 106, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1078, 106, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1079, 106, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1080, 106, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1081, 106, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1082, 106, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1083, 106, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1084, 106, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1085, 106, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1086, 106, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1087, 106, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1088, 106, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1089, 106, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1090, 106, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1091, 107, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1092, 107, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1093, 107, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1094, 107, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1095, 107, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1096, 107, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1097, 107, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1098, 107, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1099, 107, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1100, 107, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1101, 107, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1102, 107, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1103, 107, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1104, 107, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1105, 107, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1106, 108, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1107, 108, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1108, 108, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1109, 108, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1110, 108, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1111, 108, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1112, 108, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1113, 108, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1114, 108, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1115, 108, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1116, 108, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1117, 108, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1118, 108, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1119, 108, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1120, 108, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1121, 109, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1122, 109, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1123, 109, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1124, 109, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1125, 109, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1126, 109, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1127, 109, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1128, 109, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1129, 109, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1130, 109, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1131, 109, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1132, 109, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1133, 109, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1134, 109, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1135, 109, 15, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1136, 110, 1, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1137, 110, 2, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1138, 110, 3, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1139, 110, 4, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1140, 110, 5, 'VACANT', 1, 'INTERIOR', 2),
       (1000, 1141, 110, 6, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1142, 110, 7, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1143, 110, 8, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1144, 110, 9, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1145, 110, 10, 'VACANT', 2, 'OUTSIDE_VIEW', 3),
       (1000, 1146, 110, 11, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1147, 110, 12, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1148, 110, 13, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1149, 110, 14, 'VACANT', 3, 'BALCONY', 3),
       (1000, 1150, 110, 15, 'VACANT', 3, 'BALCONY', 3);

insert into cruise (id, ship_id, description)
values (101, 105, 'Historical cruise with cultural excursions'),
       (102, 103, 'Adventure cruise with wildlife sightings'),
       (103, 104, 'Historical cruise with cultural excursions'),
       (104, 102, 'Adventure cruise with wildlife sightings'),
       (105, 108, 'Historical cruise with cultural excursions'),
       (106, 108, 'Adventure cruise with wildlife sightings'),
       (107, 106, 'Family-friendly cruise with entertainment'),
       (108, 104, 'Historical cruise with cultural excursions'),
       (109, 101, 'Relaxing cruise with spa services'),
       (110, 101, 'Adventure cruise with wildlife sightings'),
       (111, 102, 'Luxurious cruise with gourmet dining'),
       (112, 108, 'Luxurious cruise with gourmet dining'),
       (113, 105, 'Luxurious cruise with gourmet dining'),
       (114, 101, 'Historical cruise with cultural excursions'),
       (115, 110, 'Adventure cruise with wildlife sightings');

insert into port (id, cruise_id, name, visit_date)
values (1001,103, 'Harbor View', '2025-02-09'),
       (1002,114, 'Sailor''s Rest Port', '2025-01-06'),
       (1003,113, 'Marina Del Sol', '2025-02-28'),
       (1004,101, 'Beachcomber''s Harbor', '2025-02-03'),
       (1005,113, 'Coastal Haven Port', '2025-02-26'),
       (1006,106, 'Captain''s Cove Port', '2025-02-04'),
       (1007,108, 'Ocean Breeze Harbor', '2025-02-11'),
       (1008,108, 'Coastal Haven Port', '2025-02-08'),
       (1009,110, 'Maritime Gateway', '2025-02-21'),
       (1010,104, 'Seascape Marina', '2025-02-28'),
       (1011,105, 'Sunset Bay Port', '2025-01-07'),
       (1012,106, 'Port of Tranquility', '2025-02-10'),
       (1013,102, 'Harbor View', '2025-01-26'),
       (1014,111, 'Beachcomber''s Harbor', '2025-01-09'),
       (1015,110, 'Port of Tranquility', '2025-01-22'),
       (1016,105, 'Palm Tree Marina', '2025-02-04'),
       (1017,109, 'Coastal Haven Port', '2025-02-21'),
       (1018,103, 'Ocean Breeze Harbor', '2025-02-01'),
       (1019,107, 'Port of Tranquility', '2025-02-19'),
       (1020,113, 'Seagull Cove Port', '2025-02-19'),
       (1021,115, 'Tropical Oasis Harbor', '2025-01-05'),
       (1022,107, 'Seafarer''s Cove', '2025-02-25'),
       (1023,110, 'Island Paradise Dock', '2025-01-20'),
       (1024,108, 'Marina Del Sol', '2025-01-11'),
       (1025,109, 'Sailor''s Rest Port', '2025-01-26'),
       (1026,102, 'Wavecrest Harbor', '2025-01-28'),
       (1027,109, 'Whale Watcher''s Port', '2025-01-27'),
       (1028,109, 'Seashore Cove Marina', '2025-01-04'),
       (1029,112, 'Seaside Marina', '2025-01-24'),
       (1030,112, 'Beachcomber''s Harbor', '2025-02-04'),
       (1031,108, 'Bayview Harbor', '2025-01-10'),
       (1032,106, 'Surfside Marina', '2025-02-14'),
       (1033,115, 'Harbor View', '2025-02-13'),
       (1034,112, 'Captain''s Cove Port', '2025-02-22'),
       (1035,106, 'Marina Del Sol', '2025-02-08'),
       (1036,114, 'Sailor''s Rest Port', '2025-02-03'),
       (1037,101, 'Anchor''s Away Marina', '2025-02-02'),
       (1038,115, 'Port of Tranquility', '2025-02-14'),
       (1039,101, 'Tropical Oasis Harbor', '2025-01-31'),
       (1040,106, 'Marina Vista', '2025-01-06'),
       (1041,105, 'Beachcomber''s Harbor', '2025-01-13'),
       (1042,109, 'Seafarer''s Cove', '2025-02-03'),
       (1043,112, 'Beachcomber''s Harbor', '2025-01-17'),
       (1044,110, 'Seashore Cove Marina', '2025-02-18'),
       (1045,111, 'Port of Tranquility', '2025-02-15'),
       (1046,114, 'Beachcomber''s Harbor', '2025-01-12'),
       (1047,106, 'Coastal Haven Port', '2025-02-20'),
       (1048,111, 'Seascape Marina', '2025-01-29'),
       (1049,110, 'Harbor View', '2025-02-27'),
       (1050,102, 'Palm Tree Marina', '2025-01-22'),
       (1051,101, 'Seascape Marina', '2025-02-24'),
       (1052,104, 'Seagull Cove Port', '2025-02-02'),
       (1053,111, 'Marina Del Sol', '2025-01-11'),
       (1054,106, 'Coastal Haven Port', '2025-02-07'),
       (1055,109, 'Sailor''s Rest Port', '2025-01-14'),
       (1056,112, 'Captain''s Cove Port', '2025-01-06'),
       (1057,114, 'Wavecrest Harbor', '2025-02-11'),
       (1058,111, 'Seashore Cove Marina', '2025-01-03'),
       (1059,107, 'Coastal Haven Port', '2025-01-16'),
       (1060,104, 'Surfside Marina', '2025-01-12'),
       (1061,104, 'Palm Tree Marina', '2025-02-28'),
       (1062,103, 'Sunset Bay Port', '2025-02-12'),
       (1063,109, 'Sailor''s Rest Port', '2025-01-13'),
       (1064,109, 'Seaside Marina', '2025-01-04'),
       (1065,113, 'Captain''s Cove Port', '2025-02-10'),
       (1066,107, 'Beachcomber''s Harbor', '2025-02-08'),
       (1067,101, 'Coastal Haven Port', '2025-02-25'),
       (1068,115, 'Palm Tree Marina', '2025-02-23'),
       (1069,115, 'Sailor''s Rest Port', '2025-01-07'),
       (1070,106, 'Harbor Master''s Dock', '2025-02-23');

-- Set duration
update public.cruise
set duration = inf.duration
from cruise cr
         inner join (select cruise_id,
                            max(port.visit_date) - min(port.visit_date) as duration
                     from port
                     group by cruise_id) inf
                    on cr.id = inf.cruise_id
where cruise.id = inf.cruise_id;

-- Set first port
update public.cruise
set first_port_id = inf.p_id
from cruise cr
         inner join (select p.cruise_id as c_id, p.id as p_id, p.visit_date
                     from port p
                     where p.visit_date = (select min(visit_date)
                                           from port
                                           where cruise_id = p.cruise_id)
                     group by p.id) inf
                    on cr.id = inf.c_id
where cruise.id = inf.c_id;

-- Set last port
update public.cruise
set last_port_id = inf.p_id
from cruise cr
         inner join (select p.cruise_id as c_id, p.id as p_id, p.visit_date
                     from port p
                     where p.visit_date = (select max(visit_date)
                                           from port
                                           where cruise_id = p.cruise_id)
                     group by p.id) inf
                    on cr.id = inf.c_id
where cruise.id = inf.c_id;

insert into ticket (id, cruise_id, seat_id, client_id, state)
values (1001, 107, 1071, 101, 'PENDING'),
       (1002, 113, 1045, 114, 'CANCELLED'),
       (1003, 103, 1005, 119, 'PAID'),
       (1004, 111, 1033, 117, 'NOT_PAID'),
       (1005, 105, 1060, 111, 'PAID'),
       (1006, 101, 1044, 120, 'NOT_PAID'),
       (1007, 109, 1126, 112, 'CANCELLED'),
       (1008, 113, 1015, 111, 'CANCELLED'),
       (1009, 107, 1054, 120, 'PENDING'),
       (1010, 102, 1129, 116, 'PAID'),
       (1011, 104, 1088, 116, 'PAID'),
       (1012, 107, 1100, 120, 'PAID'),
       (1013, 107, 1047, 110, 'PAID'),
       (1014, 115, 1096, 106, 'PENDING'),
       (1015, 114, 1100, 118, 'PAID'),
       (1016, 104, 1093, 113, 'NOT_PAID'),
       (1017, 114, 1022, 106, 'PAID'),
       (1018, 113, 1074, 104, 'PAID'),
       (1019, 108, 1073, 119, 'CANCELLED'),
       (1020, 114, 1118, 119, 'CANCELLED');

UPDATE seat
SET vacancy = 'BOOKED'
where seat.id IN (SELECT seat_id from ticket);