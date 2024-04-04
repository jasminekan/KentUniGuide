package com.example.kentuniguide;

import android.content.Context;

public class DatabasePopulator {
    private MyDatabaseHelper dbHelper;

    public DatabasePopulator(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void populateDatabase() {
        // Add data to the Offices table
        dbHelper.addOffice(222, 2, "Kemi", "Ademoye");
        dbHelper.addOffice(128, 1, "Jim", "Ang");
        dbHelper.addOffice(203, 2, "Dan", "Bard");
        dbHelper.addOffice(127, 1, "David", "Barnes");
        dbHelper.addOffice(213, 2, "Mark", "Batty");
        dbHelper.addOffice(9, 0, "Tim", "Bishop");
        dbHelper.addOffice(208, 2, "Laura", "Bocchi");
        dbHelper.addOffice(23, 0, "Vanessa", "Bonthuys");
        dbHelper.addOffice(228, 2, "Elena", "Botoeva");
        dbHelper.addOffice(117, 1, "Howard", "Bowman");
        dbHelper.addOffice(224, 2, "Janet", "Carter");
        dbHelper.addOffice(207, 2, "David", "CastroPerez");
        dbHelper.addOffice(205, 2, "Olaf", "Chitil");
        dbHelper.addOffice(124, 1, "Dominique", "Chu");
        dbHelper.addOffice(113, 1, "Sid", "Connor");
        dbHelper.addOffice(129, 1, "Ben", "Cosh");
        dbHelper.addOffice(112, 1, "John", "Crook");
        dbHelper.addOffice(127, 1, "Lisa", "Davies");
        dbHelper.addOffice(240, 2, "Sonnary", "Dearden");
        dbHelper.addOffice(212, 2, "Dominic", "Orchard");
        dbHelper.addOffice(240, 2, "Sandrine", "O'Neill");
        dbHelper.addOffice(231, 2, "Giovanni", "Masala");
        dbHelper.addOffice(210, 2, "Stefan", "Marr");
        dbHelper.addOffice(239, 2, "Zhao", "Liu");
        dbHelper.addOffice(204, 2, "Stefan", "Kahrs");
        dbHelper.addOffice(233, 2, "Ozgur", "Kafali");
        dbHelper.addOffice(225, 2, "Anna", "Jordanous");
        dbHelper.addOffice(202, 2, "Yang", "He");
        dbHelper.addOffice(221, 2, "Marek", "Grzes");
        dbHelper.addOffice(230, 2, "Ionna", "Giorgi");
        dbHelper.addOffice(226, 2, "Alex", "Freitas");
        dbHelper.addOffice(223, 2, "Christos", "Efstratiou");
        dbHelper.addOffice(232, 2, "Rogerio", "deLemos");
        dbHelper.addOffice(209, 2, "Michael", "Vollmer");
        dbHelper.addOffice(227, 2, "Daniel", "Soria");
        dbHelper.addOffice(229, 2, "Peter", "Rodgers");
        dbHelper.addOffice(206, 2, "Vineet", "Rajani");
        dbHelper.addOffice(214, 2, "Marco", "Paviotti");
        dbHelper.addOffice(248, 2, "Tommy", "Pargeter-Grey");
        dbHelper.addOffice(118, 1, "Matteo", "Migliavacca");
        dbHelper.addOffice(113, 1, "Barbara", "Tonry");
        dbHelper.addOffice(116, 1, "Jie", "Shao");
        dbHelper.addOffice(126, 1, "Palani", "Ramaswamy");
        dbHelper.addOffice(114, 1, "Doug", "Santry");
        dbHelper.addOffice(119, 1, "Fernando", "Otero");
        dbHelper.addOffice(15, 0, "Matthew", "Hibbin");
        dbHelper.addOffice(15, 0, "Fraser", "James");
        dbHelper.addOffice(19, 0, "Andy", "King");
        dbHelper.addOffice(23, 0, "George", "Langroudi");
        dbHelper.addOffice(15, 0, "Nze", "Otuneme");
        dbHelper.addOffice(23, 0, "Sergey", "Ovchinnik");
        dbHelper.addOffice(15, 0, "Piotr", "Sawicki");
        dbHelper.addOffice(23, 0, "Mark", "Sheppard");
        dbHelper.addOffice(15, 0, "Daniele", "Szilagyi");
        dbHelper.addOffice(19, 0, "Simon", "Thompson");
        dbHelper.addOffice(18, 0, "Frank", "Wang");
        dbHelper.addOffice(22, 0, "Dave", "Waterson");

        // Add data to the Rooms table
        dbHelper.addRoom("KENPC3", 1);
        dbHelper.addRoom("KENPC1", 0);
        dbHelper.addRoom("KENPC2", 0);
        dbHelper.addRoom("KENSR1", 0);
        dbHelper.addRoom("KENSR2", 0);
        dbHelper.addRoom("KENSR3", 0);
        dbHelper.addRoom("KENSR4", 0);
        dbHelper.addRoom("KENSR5", 0);
        dbHelper.addRoom("KENSR6", 1);
        dbHelper.addRoom("KENSR7", 1);
        dbHelper.addRoom("KENSR8", 1);
        dbHelper.addRoom("KENSR9", 1);
        dbHelper.addRoom("KENSR10", 1);
        dbHelper.addRoom("KENSR11", 1);

        dbHelper.addCourses("COMP3200", "Introduction to Object-Oriented Programming", "David Barnes", "DJ.Barnes@kent.ac.uk", "his module provides an introduction to object-oriented software development. Software pervades many aspects of most professional fields and sciences, and an understanding of the development of software applications is useful as a basis for many disciplines. This module covers the development of simple software systems. Students will gain an understanding of the software development process, and learn to design and implement applications in a popular object-oriented programming language. Fundamentals of classes and objects are introduced and key features of class descriptions: constructors, methods and fields. Method implementation through assignment, selection control structures, iterative control structures and other statements is introduced.");
        dbHelper.addCourses("COMP3220", "Foundations of Computing I", "Janet Carter", "J.E.Carter@kent.ac.uk", "Mathematical reasoning underpins many aspects of computer science and this module aims to provide the skills needed for other modules on the degree programme; we are not teaching mathematics for its own sake. Topics will include algebra, reasoning and proof, set theory, functions, statistics and computer arithmetic.");
        dbHelper.addCourses("COMP3250", "Foundations of Computing II", "Janet Carter", "J.E.Carter@kent.ac.uk", "This module follows from COMP3220 and aims to provide students with more understanding of the theory behind the formal underpinnings of computing. It will build upon the abstract reasoning skills introduced in COMP3220. Matrices, vectors, differential calculus, probability and logic will be introduced. ");
        dbHelper.addCourses("COMP3230", "Databases and the Web", "Ozgur Kafali", "R.O.Kafali@kent.ac.uk", "An introduction to databases and SQL, focussing on their use as a source for content for websites. Creating static content for websites using HTML(5) and controlling their appearance using CSS. Using PHP to integrate static and dynamic content for web sites. Securing dynamic websites. Using Javascript to improve interactivity and maintainability in web content.");
        dbHelper.addCourses("COMP3280", "Human Computer Interaction", "Kemi Ademoye", "K.Ademoye@kent.ac.uk", "This module provides an introduction to human-computer interaction. Fundamental aspects of human physiology and psychology are introduced and key features of interaction and common interaction styles delineated. A variety of analysis and design methods are introduced (e.g. GOMS. heuristic evaluation, user-centred and contextual design techniques). Throughout the course, the quality of design and the need for a professional, integrated and user-centred approach to interface development is emphasised. Rapid and low-fidelity prototyping feature as one aspect of this.");
        dbHelper.addCourses("COMP3270", "Computers and the Cloud", "Matteo Migliavacca", "M.Migliavacca@kent.ac.uk", "This module equips students with an understanding of how modern cloud-based applications work. Topics covered may include:\n" +
                "• A high-level view of cloud computing: the economies of scale, security issues, ethical concerns, the typical high-level architecture of a cloud-based application, types of available services (e.g., parallelization, data storage).\n" +
                "• Cloud infrastructure: command line interface; containers and virtual machines; parallelization (e.g., MapReduce, distributed graph processing); data storage (e.g., distributed file systems, distributed databases, distributed shared in-memory data structures).");
        dbHelper.addCourses("COMP3830", "Problem Solving with Algorithms", "Carlos Perez Delgado", "C.Perez@kent.ac.uk", "This module aims to strengthen the foundational programming-in-the-small abilities of students via a strong, practical, problem solving focus. Specific topics will include introductory algorithms, algorithm correctness, algorithm runtime, as well as big-O notation. Essential data structures and algorithmic programming skills will be covered, such as arrays, lists and trees, searching and sorting, recursion, and divide and conquer.");
        dbHelper.addCourses("COMP5200", "Further Object-Oriented Programming", "David Barnes", "DJ.Barnes@kent.ac.uk", "This module builds on the foundation of object-oriented design and implementation found in CO320 to provide both a broader and a deeper understanding of and facility with object-oriented program design and implementation. Reinforcement of foundational material is through its use in both understanding and working with a range of fundamental data structures and algorithms. More advanced features of object-orientation, such as interface inheritance, abstract classes, nested classes, functional abstractions and exceptions are covered. These allow an application-level view of design and implementation to be explored.");
    }
}

