/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegramservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

/**
 *
 * @author Minami
 */
public class Telegramhelper extends TelegramLongPollingBot {

    Dbhelper dbh = new Dbhelper();

    @Override
    public String getBotToken() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "229173580:AAEL0wXUn7_HbLt57uCM5h6_V3YHCfechvs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                //create a object that contains the information to send back the message

                String[] kodepesan = message.getText().toLowerCase().split("\\.");
                if (kodepesan.length == 1) {
                    SendMessage sendMessageRequest = new SendMessage();
                    sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                    sendMessageRequest.setText("Maaf Format yang anda masukan salah \n "
                            + "gunakan minta.info untuk melihat info");
                    try {
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException ex) {
                        ex.printStackTrace();
                    }
                } else if (kodepesan.length == 2) {
                    if (kodepesan[0].equals("minta")) {
                        if (kodepesan[1].equals("info")) {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText(
                                    "Kode-kode permintaan \n"
                                    + "PULSA \n"
                                    + "p5 = pulsa 5.000 (7.000)\n"
                                    + "p10 = pulsa 10.000 (12.000)\n"
                                    + "p25 = pulsa 25.000 (27.000)\n"
                                    + "p50 = pulsa 50.000 (52.000)\n\n"
                                    + "QUOTA / DATA \n"
                                    + "q1 = 1 GB  ( 11.000 )\n"
                                    + "q2 = 2 GB  ( 22.000 )\n"
                                    + "q3 = 3 gb  ( 33.000 )\n"
                                    + "q3 = 4 gb ( 45.000 )\n"
                                    + "q3 = 5 gb  ( 55.000 )\n"
                                    + "q3 = 10 gb ( 105.000 )\n"
                                    + "qult = unlimited ( 11.00 Axis)\n\n"
                                    + "Cara dan format pengiriman\n"
                                    + "SMS\n"
                                    + "dari nomor sendiri : kode (contoh : p5)\n\n"
                                    + "dari nomor lain ke nomor sendiri: kode.nomor (contoh : p5.6283129345215)\n\n"
                                    + "TELEGRAM\n"
                                    + "Dari akun sendiri atau akun lain :tel.kode.nomor (contoh : p5.6283129345215)\n\n\n"
                                    + "Untuk Info lebih lanjut silahkan hubungi kami di : 6283129345215 \n\n"
                                    + "--Terima kasih-- \n\n"
                                    + "Meteor Self Refill Pulsa \n\n"
                            );
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Maaf format salah. \n gunakan minta.info untuk melihat info");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }

                        }
                    } else {
                        String kodetarif = cektarif(kodepesan[0]);
                        String nohp = ceknohp(kodepesan[1]);

                        if (nohp.equals("") || nohp == null) {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Maaf nomor belum terdaftar. \n hubungi 083129345215 untuk mendaftar");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                        } else if (kodetarif.equals("") || kodetarif == null) {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Maaf layanan tidak tersedia. \n gunakan minta.info untuk melihat info");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Permintaan sedang diproses, mohon tunggu");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }

                            insertpesan(String.valueOf(message.getDate()), nohp, message.getText());
                            inserttransaksi(nohp, kodetarif);

                        }
                    }

                } else if (kodepesan.length == 3) {

                    if (kodepesan[0].equals("mbk201")) {
                        String kodetarif = cektarif(kodepesan[1]);

                        if (kodetarif.equals("") || kodetarif == null) {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Maaf layanan tidak tersedia. \n gunakan minta.info untuk melihat info");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            SendMessage sendMessageRequest = new SendMessage();
                            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                            sendMessageRequest.setText("Permintaan sedang diproses, mohon tunggu");
                            try {
                                sendMessage(sendMessageRequest);
                            } catch (TelegramApiException ex) {
                                ex.printStackTrace();
                            }
                            insertpesan(String.valueOf(message.getDate()), kodepesan[2], message.getText());
                            inserttransaksi(kodepesan[2], kodetarif);

                        }

                    } else {
                        SendMessage sendMessageRequest = new SendMessage();
                        sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                        sendMessageRequest.setText("Maaf Format Salah. \n gunakan minta.info untuk melihat info");
                        try {
                            sendMessage(sendMessageRequest);
                        } catch (TelegramApiException ex) {
                            ex.printStackTrace();
                        }
                    }

                } else {
                    SendMessage sendMessageRequest = new SendMessage();
                    sendMessageRequest.setChatId(message.getChatId().toString()); //who should get the message? the sender from which we got the message...
                    sendMessageRequest.setText("Maaf Format Salah. \n gunakan minta.info untuk melihat info");
                    try {
                        sendMessage(sendMessageRequest);
                    } catch (TelegramApiException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        }
    }

    @Override
    public String getBotUsername() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "mulyadi_bot";
    }

    public String cektarif(String tarif) {
        String kodeussd = "";
        try {
            dbh.connect();
            Object[] oussd = new Object[1];
            oussd[0] = tarif;
            ResultSet resussd = dbh.readdetail("SELECT kode FROM data_tarif WHERE id=?", 1, oussd).executeQuery();
            while (resussd.next()) {
                kodeussd = resussd.getString("kode");
            }
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Telegramhelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kodeussd;
    }

    public String ceknohp(String nohp) {
        String notujuan = "";
        try {
            dbh.connect();
            Object[] onohp = new Object[1];
            onohp[0] = nohp;
            ResultSet resnohp = dbh.readdetail("SELECT nohp FROM data_member WHERE nohp=?", 1, onohp).executeQuery();
            while (resnohp.next()) {
                notujuan = resnohp.getString("nohp");
            }
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Telegramhelper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return notujuan;
    }

    public void insertpesan(String tanggal, String nohp, String pesan) {
        try {
            dbh.connect();
            Object[] op = new Object[4];
            op[0] = tanggal;
            op[1] = nohp;
            op[2] = pesan;
            op[3] = "SMS";
            dbh.insert("INSERT INTO data_pesan(tanggal_masuk,nohp,pesan,kategori) VALUES(?,?,?,?)", 4, op);
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Telegramhelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void inserttransaksi(String nohp, String idtarif) {
        try {
            dbh.connect();
            Object[] ot = new Object[3];
            ot[0] = nohp;
            ot[1] = idtarif;
            ot[2] = "Belum Terkonfirmasi";
            dbh.insert("INSERT INTO data_transaksi(nohp,id_tarif,status) VALUES(?,?,?)", 3, ot);
            dbh.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(Telegramhelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
