#!/usr/bin/env groovy

def call(String botToken, String chatId, String status, String job, String build){
    curl -X POST \
     -H 'Content-Type: application/json' \
     -d '{"chat_id": "'${CHAT_ID}'","parse_mode":"HTML", "text": "<b>[Jenkins - '${STATUS}']</b>\nJob: '${JOB}'\nBuild: '${BUILD}'", "disable_notification": true}' \
     https://api.telegram.org/bot$BOT_TOKEN/sendMessage
}
