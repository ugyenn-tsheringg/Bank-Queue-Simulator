# Bank Queue Simulator GUI

This project is a graphical user interface (GUI) application developed as part of a Data Structures and Algorithms course assignment. The **Bank Queue Simulator GUI** simulates a bank queue system, allowing users to Juno-based bank queue simulation with customizable parameters such as the number of service counters, number of customers, service time per customer, and customer arrival rate. The simulation provides results such as average waiting time and queue length.

## Features
- Input fields for number of service counters, number of customers, service time, and arrival rate.
- User-friendly GUI built with Java Swing.
- Displays simulation results in a popup dialog.
- Validates input to ensure valid numbers are entered.
- Supports Enter key to trigger simulation.
- Includes a logo and styled UI for better user experience.

## Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- A Java IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with command-line compilation tools.
- A logo image file (JPEG format) for the GUI (update the path in the code if needed).

## Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd <repository-folder>

2. **Update Logo Path**:
- Open BankQueueSimulatorGUI.java.
- Modify the setLogo method to point to a valid JPEG image file on your system:
```bash
setLogo("path/to/your/logo.jpeg");
```
- If you don't have a logo, you can comment out the setLogo call, but the GUI may not display an image.

3. **Compile the Code**:
```base
javac BankQueueSimulatorGUI.java
```  
4. **Run the Application**:
```bash
java BankQueueSimulatorGUI
```

## Usage
Launch the application. A GUI window titled "Bank Queue Simulator" will appear.
Enter the following parameters:
  - Number of Service Counters: Number of bank counters (e.g., 3).
  - Number of Customers: Total customers to simulate (e.g., 50).
  - Time Each Customer Takes: Service time per customer in time units (e.g., 5).
  - Customers Arriving Per Unit Time: Arrival rate (e.g., 2).

Click the Simulate button or press Enter in any input field to run the simulation.
View the results in a popup dialog, which includes metrics like average waiting time and queue length.

## Notes
- The BankSimulation class is not included in this repository as it was likely provided as part of the assignment. Ensure you have the BankSimulation class in your classpath 
 for the program to work.  
- If the logo image path is invalid, the GUI may not display the logo, but the simulation will still function.
- Input validation ensures only valid numbers are accepted. Invalid inputs will trigger an error message.

## Limitations
- The BankSimulation class is assumed to exist and handle the core queue simulation logic. Without it, the program will not compile.
- The logo image path is hardcoded and must be updated for your environment.
- No error handling for edge cases like negative numbers or zero counters/customers.

## Contributing
This is a course assignment project and not actively maintained. Feel free to fork the repository and adapt it for your needs. For suggestions or issues, create a GitHub issue in the repository.

## License
This project is licensed under the MIT License. See the LICENSE file for details (not included in this repository).


