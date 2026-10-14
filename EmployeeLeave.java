
package com.example.leave;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeLeave {

    private int employeeId;

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @NotBlank(message = "Leave type is mandatory")
    private String leaveType;

    @Min(value = 1, message = "Leave days should be minimum 1")
    private int numberOfDays;

    private String reason;

    public EmployeeLeave(int employeeId, String employeeName,
                         String leaveType, int numberOfDays,
                         String reason) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "\nEmployee ID: " + employeeId
                + "\nEmployee Name: " + employeeName
                + "\nLeave Type: " + leaveType
                + "\nNumber of Days: " + numberOfDays
                + "\nReason: " + reason;
    }
}