--
-- File generated with SQLiteStudio v3.0.7 on Thu Dec 1 14:36:30 2016
--
-- Text encoding used: windows-1252
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Clothes
CREATE TABLE Clothes (ClothesID INT PRIMARY KEY UNIQUE NOT NULL, ColourID INT REFERENCES Colour (ColourID) NOT NULL, PatternID INT REFERENCES Pattern (PatternID) NOT NULL, TypeID INT REFERENCES Type (TypeID) NOT NULL, Names VARCHAR, BrandID INT REFERENCES Brand (BrandID));
INSERT INTO Clothes (ClothesID, ColourID, PatternID, TypeID, Names, BrandID) VALUES (1, 1, 1, 2, 'Skater Skirt', NULL);

-- Table: Colour
CREATE TABLE Colour (ColourID INT PRIMARY KEY UNIQUE NOT NULL, Colour VARCHAR);
INSERT INTO Colour (ColourID, Colour) VALUES (1, 'Black');
INSERT INTO Colour (ColourID, Colour) VALUES (2, 'Blue');
INSERT INTO Colour (ColourID, Colour) VALUES (3, 'Orange');
INSERT INTO Colour (ColourID, Colour) VALUES (4, 'Yellow');
INSERT INTO Colour (ColourID, Colour) VALUES (5, 'Red');
INSERT INTO Colour (ColourID, Colour) VALUES (6, 'Brown');
INSERT INTO Colour (ColourID, Colour) VALUES (7, 'Pink');
INSERT INTO Colour (ColourID, Colour) VALUES (8, 'Nude');
INSERT INTO Colour (ColourID, Colour) VALUES (9, 'Purple');
INSERT INTO Colour (ColourID, Colour) VALUES (10, 'Green');

-- Table: Pattern
CREATE TABLE Pattern (PatternID INT PRIMARY KEY UNIQUE NOT NULL, Pattern VARCHAR);
INSERT INTO Pattern (PatternID, Pattern) VALUES (1, 'Plain');
INSERT INTO Pattern (PatternID, Pattern) VALUES (2, 'Striped');
INSERT INTO Pattern (PatternID, Pattern) VALUES (3, 'Polkadot');
INSERT INTO Pattern (PatternID, Pattern) VALUES (4, 'Pictures');
INSERT INTO Pattern (PatternID, Pattern) VALUES (5, 'Checkered');
INSERT INTO Pattern (PatternID, Pattern) VALUES (6, 'Tartan');
INSERT INTO Pattern (PatternID, Pattern) VALUES (8, 'Plaid');
INSERT INTO Pattern (PatternID, Pattern) VALUES (7, 'Floral');

-- Table: Type
CREATE TABLE Type (TypeID INT PRIMARY KEY UNIQUE NOT NULL, Type VARCHAR);
INSERT INTO Type (TypeID, Type) VALUES (1, 'Trousers');
INSERT INTO Type (TypeID, Type) VALUES (2, 'Skirt');
INSERT INTO Type (TypeID, Type) VALUES (3, 'Dress');
INSERT INTO Type (TypeID, Type) VALUES (4, 'Tshirt');
INSERT INTO Type (TypeID, Type) VALUES (5, 'Long sleeved top');
INSERT INTO Type (TypeID, Type) VALUES (6, 'Hoodie');
INSERT INTO Type (TypeID, Type) VALUES (7, 'Shoes');
INSERT INTO Type (TypeID, Type) VALUES (8, 'Shirts');
INSERT INTO Type (TypeID, Type) VALUES (9, 'Jeans');
INSERT INTO Type (TypeID, Type) VALUES (10, 'Boots');
INSERT INTO Type (TypeID, Type) VALUES (11, 'Acessories');
INSERT INTO Type (TypeID, Type) VALUES (12, 'Coats');
INSERT INTO Type (TypeID, Type) VALUES (13, 'Jumpsuit');
INSERT INTO Type (TypeID, Type) VALUES (14, 'Shorts');
INSERT INTO Type (TypeID, Type) VALUES (15, 'Jackets');
INSERT INTO Type (TypeID, Type) VALUES (16, 'Vests');
INSERT INTO Type (TypeID, Type) VALUES (17, 'Undergarments');

-- Table: Brand
CREATE TABLE Brand (BrandID INT PRIMARY KEY UNIQUE NOT NULL, Brand VARCHAR);
INSERT INTO Brand (BrandID, Brand) VALUES (1, 'TopShop');
INSERT INTO Brand (BrandID, Brand) VALUES (2, 'NewLook');
INSERT INTO Brand (BrandID, Brand) VALUES (3, 'H&M');
INSERT INTO Brand (BrandID, Brand) VALUES (4, 'Pull & Bear');
INSERT INTO Brand (BrandID, Brand) VALUES (5, 'Acne Studios');
INSERT INTO Brand (BrandID, Brand) VALUES (6, 'Gucci');
INSERT INTO Brand (BrandID, Brand) VALUES (7, 'Calvein Klein');
INSERT INTO Brand (BrandID, Brand) VALUES (8, 'Armani Exchange');
INSERT INTO Brand (BrandID, Brand) VALUES (9, 'Nike');
INSERT INTO Brand (BrandID, Brand) VALUES (10, 'Addidas');
INSERT INTO Brand (BrandID, Brand) VALUES (11, 'UNIQLO');
INSERT INTO Brand (BrandID, Brand) VALUES (12, 'ZARA');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
