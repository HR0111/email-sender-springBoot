+-----------------------------------+
|              User                 |
+-----------------------------------+
| - id: Long                        |
| - email: String                   |
| - password: String                |
| - role: Role (EMPLOYEE/HR)        |
+-----------------------------------+
| + getId(): Long                   |
| + getEmail(): String              |
| + getRole(): Role                 |
| + getEmployee(): Employee         |
+-----------------------------------+

+-----------------------------------+
|            Employee               |
+-----------------------------------+
| - id: Long                        |
| - user: User                      |
| - name: String                    |
| - department: String              |
| - joiningDate: LocalDate          |
| - leaveBalance: int               |
+-----------------------------------+
| + getId(): Long                   |
| + getName(): String               |
| + getLeaveBalance(): int          |
| + setLeaveBalance(int): void      |
+-----------------------------------+

+-----------------------------------+
|          LeaveRequest             |
+-----------------------------------+
| - id: Long                        |
| - employee: Employee              |
| - startDate: LocalDate            |
| - endDate: LocalDate              |
| - daysRequested: int              |
| - status: LeaveStatus             |
| - reason: String                  |
| - rejectionReason: String         |
| - appliedAt: LocalDateTime        |
+-----------------------------------+
| + getId(): Long                   |
| + getEmployee(): Employee         |
| + getStatus(): LeaveStatus        |
| + setStatus(LeaveStatus): void    |
+-----------------------------------+

+-----------------------------------+
|         AuthController            |
+-----------------------------------+
| - authService: AuthService        |
+-----------------------------------+
| + login(): ResponseEntity         |
| + signup(): ResponseEntity        |
+-----------------------------------+

+-----------------------------------+
|        LeaveController            |
+-----------------------------------+
| - leaveService: LeaveService      |
+-----------------------------------+
| + applyLeave(): ResponseEntity    |
| + getMyLeaves(): ResponseEntity   |
| + getLeaveBalance(): ResponseEntity|
+-----------------------------------+

+-----------------------------------+
|    LeaveManagementController      |
+-----------------------------------+
| - leaveService: LeaveService      |
+-----------------------------------+
| + getAllLeaves(): ResponseEntity  |
| + approveLeave(): ResponseEntity  |
| + rejectLeave(): ResponseEntity   |
| + cancelLeave(): ResponseEntity   |
+-----------------------------------+


+-------------------------------------------+
|              LeaveService                 |
+-------------------------------------------+
| - userRepository: UserRepository          |
| - employeeRepository: EmployeeRepository  |
| - leaveRepository: LeaveRepository        |
+-------------------------------------------+
| + applyLeave(): LeaveRequest              |
| + approveLeave(): LeaveRequest            |
| + rejectLeave(): LeaveRequest             |
| + cancelApprovedLeave(): LeaveRequest     |
| + getLeaveBalance(): LeaveBalanceResponse |
| + getEmployeeLeaveHistory(): List         |
| + getAllPendingLeaves(): List             |
| - validateLeaveDates(): void              |
| - checkForOverlappingLeaves(): void       |
| - calculateLeaveDays(): int               |
+-------------------------------------------+

+-----------------------------------+
|         UserRepository            |
+-----------------------------------+
| + findByEmail(): Optional<User>   |
| + save(): User                    |
| + findById(): Optional<User>      |
+-----------------------------------+

+-----------------------------------+
|       EmployeeRepository          |
+-----------------------------------+
| + findById(): Optional<Employee>  |
| + save(): Employee                |
| + findAll(): List<Employee>       |
+-----------------------------------+

+-----------------------------------+
|       LeaveRepository             |
+-----------------------------------+
| + save(): LeaveRequest            |
| + findById(): Optional            |
| + findByEmployeeId(): List        |
|                                   | 
+-----------------------------------+
