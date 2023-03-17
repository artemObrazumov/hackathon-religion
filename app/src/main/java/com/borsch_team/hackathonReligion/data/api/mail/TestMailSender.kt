package com.borsch_team.hackathonReligion.data.api.mail

import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class TestMailSender {
    companion object{
        suspend fun sendEmail(TextMessage: String){
            val from = "FSL-Tikaani@yandex.ru"
            val pass = "zdykvlxxhatjzxuj"
            val to = arrayOf("romik152006@mail.ru")
            val host = "smtp.yandex.com"
            val props = System.getProperties()

            props["mail.smtp.host"] = host
            props["mail.smtp.user"] = from
            props["mail.smtp.password"] = pass
            props["mail.smtp.port"] = "465"
            props["mail.smtp.auth"] = "true"
            props["mail.smtp.starttls.enable"] = "true"
            props["mail.smtp.ssl.enable"] = "true"
            props["mail.smtp.quitwait"] = "false"
            props["mail.smtp.socketFactory.class"] = "javax.net.ssl.SSLSocketFactory"
            props["mail.debug"] = "true"

            val session = Session.getDefaultInstance(props,
                object : Authenticator() {
                    override fun getPasswordAuthentication(): PasswordAuthentication {
                        return PasswordAuthentication(
                            from, pass
                        )
                    }
                })

            try {
                val message: Message = MimeMessage(session)
                message.setFrom(InternetAddress("FSL-Tikaani@yandex.ru"))
                message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to[0])
                )
                message.subject = "Testing Subject"
                message.setText(TextMessage)
                Runnable{
                    Transport.send(message)
                }.run()

                println("Email sent successfully.")
            } catch (e: MessagingException) {
                throw RuntimeException(e)
            }
        }
    }
}