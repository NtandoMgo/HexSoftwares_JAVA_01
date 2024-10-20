
# Student Grade Calculator

This is a Java-based application designed to manage student grades efficiently. It allows users to calculate the average grades of students, determine their pass or fail status, and manage student data with a web interface. The application uses Spring Boot for the backend and Thymeleaf for the frontend, with PostgreSQL as the database.

## Features

- Add and manage multiple student records.
- Calculate the average grade of individual students.
- Determine pass or fail status based on the calculated average.
- Calculate class average across all students.
- Web-based interface for easy data input and management.
- Synchronization between frontend and backend to ensure data consistency.

## Tech Stack

- **Frontend:** Thymeleaf, HTML, CSS
- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **Build Tool:** Gradle
- **Other:** Synchronization mechanisms for consistency

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/NtandoMgo/HexSoftwares_Student-Grade-Calculator.git
   cd HexSoftwares_Student-Grade-Calculator
   ```

2. Configure the PostgreSQL database:

   - Make sure PostgreSQL is installed and running.
   - Create a database named `studentdb`.
   - Update the `application.properties` file with your database credentials.

3. Build and run the application:

   ```bash
   ./gradlew build
   ./gradlew bootRun
   ```

4. Access the application in your browser at `http://localhost:8080`.

## Usage

- **Add Student:** Navigate to the Add Student page, input student details, and save.
- **View Students:** Access the list of students, along with their grades and status.
- **Calculate Averages:** The application will automatically calculate and update averages.

## Future Enhancements

- Export student data to CSV.
- Integrate user authentication for secure access.
- Add additional statistics like highest and lowest grades in the class.

## License

This project is open-source and available under the MIT License.

## Contact

For further inquiries, please contact [Ntando](mailto:ntando.personal@gmail.com).