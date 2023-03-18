package com.borsch_team.hackathonReligion.data.api.mail

import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


class TestMailSender {
    companion object{
        suspend fun sendEmail(textMessage: String, textSubject: String){
            // Данные от аккаунта Яндекса
            val from = "FSL-Tikaani@yandex.ru"
            val pass = "zdykvlxxhatjzxuj"
            // Данные получателя
            val to = "parfenov-dmitry1986@yandex.ru"
            // Настройки SMTP Яндекса
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
            // Настраиваем сессию с нашими данными для входа
            val session = Session.getDefaultInstance(props,
                object : Authenticator() {
                    override fun getPasswordAuthentication(): PasswordAuthentication {
                        return PasswordAuthentication(
                            from, pass
                        )
                    }
                })
            // Пробуем отправить
            try {
                val message: Message = MimeMessage(session)
                // От чьего имени отправляем письмо
                message.setFrom(InternetAddress(from))
                // Устанавливаем целевой адресс отправки
                message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
                )
                // Устанавливаем тему сообщения
                message.subject = textSubject
                // Устанавливаем текст сообщения
                message.setText(textMessage)
                // В отдельном потоке отправлеям письмо
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