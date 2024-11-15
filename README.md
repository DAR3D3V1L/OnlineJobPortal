# Job Portal Web Application

This is a **Job Portal** web application built using **Spring Boot**, **Spring Data JPA**, and **MySQL**. It allows users to search for jobs, apply for positions, and for admins to manage job listings and user applications.

## Features

- **User Registration & Login**: Users can register, log in, and manage their profiles.
- **Job Listings**: Users can view available job positions and apply for jobs.
- **Admin Panel**: Admins can add, update, or delete job listings and view user applications.
- **Search & Filter Jobs**: Users can search for jobs based on various filters.
- **MySQL Database**: Job listings and user data are stored in a MySQL database.

## Technologies Used

- **Java 11** (JDK 11)
- **Spring Boot 2.x** (for backend and APIs)
- **Spring Data JPA** (for database interaction)
- **Spring Security** (for user authentication and authorization)
- **Thymeleaf** (for rendering views)
- **MySQL** (for data storage)
- **Maven** (for project build and dependency management)
- **Bootstrap** (for responsive front-end design)

## Project Setup

Follow these steps to set up the Job Portal project locally:

### Prerequisites

1. **Java 11** or later installed on your machine.
2. **Maven** installed for project management.
3. **MySQL** database running locally or on a remote server.

### Steps to Run the Application

1. **Clone the repository**:
   ```bash
   git clone https://github.com/DAR3D3V1L/OnlineJobPortal.git
   cd OnlineJobPortal
   ```

2. **Configure the application properties**:
   - Open `src/main/resources/application.properties` or `application.yml`.
   - Configure your database connection:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/job_portal_db
     spring.datasource.username=root
     spring.datasource.password=yourpassword
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
     ```

3. **Build the project**:
   Run the following Maven command to build the project:
   ```bash
   mvn clean install
   ```

4. **Run the application**:
   Start the application using:
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**:
   Open a web browser and go to `http://localhost:8080` to access the Job Portal.

### Database Setup

1. Create a MySQL database named `job_portal_db` (or whatever name you prefer).
2. Make sure to update the database credentials (username, password) in the `application.properties` file.

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a pull request for review.
