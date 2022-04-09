#!/usr/bin/env groovy

def call(String botToken, String chatId, String status, String job, String build){
    sh """
        curl -X POST -H 'Content-Type: application/json' -d '{"chat_id": "'${chatId}'","parse_mode":"HTML", "text": "<b>[Jenkins - '${status}']</b>\nJob: '${job}'\nBuild: '${build}'", "disable_notification": true}'      https://api.telegram.org/bot$botToken/sendMessage
    """
}