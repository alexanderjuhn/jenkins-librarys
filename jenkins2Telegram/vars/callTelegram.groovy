#!/usr/bin/env groovy
def call(String status, String job, String build){
    withCredentials([string(credentialsId: 'TelegramChatID', variable: 'CHAT_ID'), string(credentialsId: 'TelegramBotToken', variable: 'BOT_TOKEN')]) {
        sh """
            curl -X POST -H 'Content-Type: application/json' -d '{"chat_id": "'${CHAT_ID}'","parse_mode":"HTML", "text": "<b>[Jenkins - '${status}']</b>\nJob: '${job}'\nBuild: '${build}'", "disable_notification": true}'      https://api.telegram.org/bot${BOT_TOKEN}/sendMessage
        """
    }
}
