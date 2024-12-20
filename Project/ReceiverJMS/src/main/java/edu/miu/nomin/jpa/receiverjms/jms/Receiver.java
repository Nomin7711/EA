package edu.miu.nomin.jpa.receiverjms.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Receiver {

    @JmsListener(destination = "smsQueue")
    public void receiveSmsMessage(HashMap<String, Object> params) {
        String name = (String) params.get("Name");
        String phoneNumber = (String) params.get("PhoneNumber");
        String messageType = (String) params.get("MessageType");
        String appointmentId = (String) params.get("AppointmentId");
        String date = (String) params.get("Date");

        if ("APPOINTMENT_CREATED".equals(messageType)) {
            sendAppointmentCreatedSms(phoneNumber, name, appointmentId, date);
        } else if ("STATUS_CHANGED".equals(messageType)) {
            String status = (String) params.get("Status");
            sendStatusChangedSms(phoneNumber, name, status, appointmentId, date);
        }
    }

    private void sendAppointmentCreatedSms(String phoneNumber, String name, String appointmentId, String date) {
        String messageContent = String.format("Hello %s, your appointment (ID: %s) is confirmed for %s.", name, appointmentId, date);
        System.out.println(messageContent + " Sent to phone number " + phoneNumber);
    }

    private void sendStatusChangedSms(String phoneNumber, String name, String status, String appointmentId, String date) {
        String messageContent = String.format("Hello %s, your appointment (ID: %s) status has been updated to %s. Date: %s", name, appointmentId, status, date);
        System.out.println(messageContent + " Sent to phone number " + phoneNumber);
    }

}
