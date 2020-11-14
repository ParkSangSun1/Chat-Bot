package com.example.chatbot.utils

import com.example.chatbot.utils.Constants.OPEN_GOOGLE
import com.example.chatbot.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            //명령어 메뉴판



            //명령어
            message.contains("안녕") -> {
                when (random) {
                    0 -> "안녕하세요"
                    1 -> "네 안녕하세요"
                    2 -> "Buongiorno!"
                    else -> "error" }
            }

            message.contains("몇살") && message.contains("?") -> {
                when (random) {
                    0 -> "아직 아기 입니다"
                    1 -> "그러게요, 개통일이 언제더라"
                    2 -> "계산하기 귀찮아요"
                    else -> "error"
                }
            }

            //숨겨진 친구들 이름
            message.contains("강산하") -> {
                when (random) {
                    0 -> "그는..."
                    1 -> "빙신"
                    2 -> "그 이름을 부르지 마세요"
                    else -> "error"
                }
            }
            message.contains("김태민") -> {
                when (random) {
                    0 -> "-메-"
                    1 -> "험난한 인생"
                    2 -> "게임이 너무 좋아요"
                    else -> "error"
                }
            }
            message.contains("차경민") -> {
                when (random) {
                    0 -> "인베디드는 저의 특기죠"
                    1 -> "하~ 납 냄새가 가장 좋아요"
                    2 -> "Pb"
                    else -> "error"
                }
            }
            message.contains("서채운") -> {
                when (random) {
                    0 -> "저는 인베디드"
                    1 -> "납이 좋아요"
                    2 -> "아두두두두이노"
                    else -> "error"
                }
            }
            message.contains("민경모") -> {
                when (random) {
                    0 -> "저는..."
                    1 -> "슬프네요ㅠㅠ"
                    2 -> "사랑은 사랑으로 잊으라는 말이 있죠"
                    else -> "error"
                }
            }

            //시간을 물어보는
            message.contains("몇시") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }
            message.contains("시간") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //구글 열기
            message.contains("구글") && message.contains("시작해")-> {
                OPEN_GOOGLE
            }
            message.contains("google") && message.contains("시작해")-> {
                OPEN_GOOGLE
            }
            message.contains("구글") && message.contains("열어줘")-> {
                OPEN_GOOGLE
            }
            message.contains("google") && message.contains("시작해")-> {
                OPEN_GOOGLE
            }

            //인터넷 검색
            message.contains("검색")-> {
                OPEN_SEARCH
            }


            //명령어에 없는 그 밖에 내용들
            else -> {
                when (random) {
                    0 -> "이해하지 못했습니다.."
                    1 -> "무슨 말씀이시나요?"
                    2 -> "알아듣지 못하겠어요"
                    3 -> "이 말은 학습하지 못했어요"
                    else -> "에러"
                }
            }
        }
    }
}