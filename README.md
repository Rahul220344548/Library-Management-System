	Library Management System

Description: 

The Library Management System is a console-based application that helps to manage books in a library. 
The system allows the user to add new books, issue books to users, return books, and track issued books.
It is developed using Object-Oriented Programming (OOP) concepts, utilizing collections (List, ArrayLists) 
and basic file handling for data persistence.

	Features
- Add New Books: Allows you to add new books to the library's collection.
- Issue Books: Issue books to registered users and keep track of the issued books.
- Return Books: Return books that were previously issued and mark them as available again.
- Track Issued Books: View the list of books that have been issued to users.
- User Management: Add users who can borrow books from the library.
- File Handling: All data is persisted locally using file handling, so the library and user data remain intact between sessions.

	Usage

1. Main menu: 

<img width="773" alt="image" src="https://github.com/user-attachments/assets/d44d5b50-1138-4d7d-8812-a05b7de24dcf">

2. Add New Book:
- Allows you to input a new book’s details like title, and author into books.csv file.
- generates a ISBN number for book , to use when removing 

<img width="777" alt="image" src="https://github.com/user-attachments/assets/1e42bb6d-d4f2-40fb-95ba-a09c39842258">
<img width="261" alt="image" src="https://github.com/user-attachments/assets/2ec41de5-6704-41a6-94b7-7f61f1066e84">

3. Remove a book:

- Searchs for a book IBSN number to remove book
<img width="773" alt="image" src="https://github.com/user-attachments/assets/41e52212-93fc-40cf-9ec7-fc624ae82279">


4. Add User:
- Add a new user by providing a unique user ID to users and allows to input Full name and Address
- This user is then stored in users.csv file 

<img width="775" alt="image" src="https://github.com/user-attachments/assets/ddb1b670-70b4-4607-9080-95ec865cdbeb">
<img width="308" alt="image" src="https://github.com/user-attachments/assets/ba93e438-ae20-43fd-965e-4910800e72d5">

5. Issue book:

- Issue a book to a user by entering the bookID and userID.
- The system checks if the book is available and issues it to the user
- User status is set to true 

<img width="776" alt="image" src="https://github.com/user-attachments/assets/5050fb75-c3c5-4de4-97e0-2f8d855eba39">
<img width="398" alt="image" src="https://github.com/user-attachments/assets/c7c8d07c-ca25-428b-8476-47baef58e30c">

6. Return a Book:

- Return a previously issued book by entering the bookID and userID.
- The system will mark the book as available.

<img width="769" alt="image" src="https://github.com/user-attachments/assets/6212636d-f428-4a35-aa9f-099450bb113f">

<img width="263" alt="image" src="https://github.com/user-attachments/assets/2ea316ec-2541-4c4a-85ef-3c315b3c3825">
<img width="512" alt="image" src="https://github.com/user-attachments/assets/2062293c-5c29-4a5d-bce6-d83ad77e5066">

7. Display all Books: 
- View the list of all books in the library, including information about which books are issued and which are available.
  
<img width="778" alt="image" src="https://github.com/user-attachments/assets/4617ee88-5032-4b13-9e04-e34ccb5f139c">

8. Display all Users: 
- View the list of all registered users and the books they have issued.

<img width="770" alt="image" src="https://github.com/user-attachments/assets/5b94505d-e4d7-487c-993c-37acb464e405">

8. Save & Exit:
- Saves all changes to files and exits the application.

<img width="775" alt="image" src="https://github.com/user-attachments/assets/93dd7581-8a25-4e51-9961-37d5368aebfa">

	Data Persistence
All the data, such as the list of books and users, is stored in text files or JSON files
(depending on your implementation). Each time you run the program, it loads the data from these files
and saves the state upon exiting. This ensures that the library’s inventory and user data are not lost between sessions.

	Future Enhancements
- Add a search functionality to find books by title, author, or genre.
- Implement a fine system for overdue books.
- Improve the UI by implementing a graphical user interface (GUI).

