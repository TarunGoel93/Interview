package org.example;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
@Slf4j
@Async
public class Service {

    private EmailService emailService;

    private File convertMultiPartToFile(MultipartFile multipartFile) throws IOException {
        File file;
        try {
            file = File.createTempFile("temp", null);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("Error converting MultipartFile to File: " + e.getMessage());
        }
        return file;
    }

    private List<Employee> readEmployeesFromExcel(File file) throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Employee employee = createEmployeeFromRow(row);
                employees.add(employee);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return employees;
    }

    private Employee createEmployeeFromRow(Row row) {
        Employee employee = new Employee();
        employee.setId(Long.valueOf((long) row.getCell(0).getNumericCellValue()));
        employee.setEmail(String.valueOf(row.getCell(1).getNumericCellValue()));

        return employee;
    }



    public void importEmployeeFromExcel(MultipartFile multipartFile,String body) throws MessagingException {
        try {
            log.info(Thread.currentThread().getName() + " Thread Name");
            File file = this.convertMultiPartToFile(multipartFile);
            List<Employee> employees = readEmployeesFromExcel(file);


            List<String> emails = new ArrayList<>();
            for (Employee employee : employees) {
                emails.add(employee.getEmail());
            }


            if (file != null && file.exists()) {
                Files.delete(file.toPath());
            }
            for (String email : emails) {
                emailService.sendMailWithAttachment(body, email, "Selected For Interview");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
