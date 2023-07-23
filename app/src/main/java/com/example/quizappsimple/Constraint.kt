package com.example.quizappsimple

object Constraint {
    const val USER_NAME = "user_name"
    const val SCORE = "score"
    const val TOTAL_QUEST = "total_quest"
    const val HISTORY_CHOOSE = "history_choose"
    fun getQuestion():ArrayList<Question>{
        val ListQuestion = ArrayList<Question>()
        //Q1
        ListQuestion.add(Question(
            1,
            "Mạng Internet Là?",
            "Mạng Client-Server",
            "Mạng toàn cầu",
            "Mạng cục bộ LAN",
            "Mạng diện rộng WAN",
            2
        ))
        //Q2
        ListQuestion.add(Question(
            2,
            "Mỗi máy tính tham gia vào mạng đều có 1 điạ chỉ duy nhất được gọi là địa chỉ?",
            "HTTP",
            "HTML",
            "IP",
            "TCP/IP",
            4
        ))
        //Q3
        ListQuestion.add(Question(
            3,
            "Mạng internet ra đời năm nào?",
            "1956",
            "1969",
            "1970",
            "1980",
            2
        ))
        //Q4
        ListQuestion.add(Question(
            4,
            "SMS là viết tắt của Short Message Services, có nghĩa là :",
            "Dịch vụ tin nhắn ngắn",
            "Một giao thức viễn thông cho phép gửi các thông điệp dạng text ngắn (không quá 160 ký tự)",
            "Giao thức này có trên hầu hết các thiết bị di động di động",
            "Cả A,B,C đều đúng",
            4
        ))
        //Q5
        ListQuestion.add(Question(
            5,
            "IM : Instant Messaging là dịch vụ:",
            "Trao đổi thông tin bằng giọng nói (voice)",
            "Trao đổi thông tin bằng hình ảnh (video)",
            "Là dịch vụ cho phép hai người trở lên nói chuyện trực tuyến (chat, text) với nhau qua một mạng" +
                    " máy tính.Dịch vụ này đã thúc đẩy sự phát triển của Internet trong đầu thập niên 2000",
            "Dịch vụ tin nhắn offline",
            3
        ))
        //Q6
        ListQuestion.add(Question(
            6,
            "Trong mạng máy tính, thuật ngữ Share có ý nghĩa gì?",
            "Chia sẻ tài nguyên",
            "Nhãn hiệu của một thiết bị kết nối mạng",
            "Lệnh in trong mạng cục bộ",
            "Tên phần mềm hỗ trợ sử dụng mạng cục bộ",
            1
        ))
        //Q7
        ListQuestion.add(Question(
            7,
            "WWW là viết tắt của cụm từ nào sau đây:",
            "World Wide Web",
            "World Win Web",
            "World Wired Web",
            "Windows Wide Web",
            1
        ))
        //Q8
        ListQuestion.add(Question(
            8,
            "Dịch vụ thư điện tử được dùng để làm gì?",
            "Trao đổi thông tin trực tuyến",
            "Hộp thoại trực tuyến",
            "Trao đổi thư thông qua môi trường Internet",
            "Tìm kiếm thông tin",
            1
        ))
        //Q9
        ListQuestion.add(Question(
            9,
            "Cho biết địa chỉ http://www.vhu.edu.vn là loại tổ chức gì?",
            "Tổ chức thương mại",
            "Tổ chức y tế",
            "Tổ chức chính phủ",
            "Tổ chức giáo dục",
            4
        ))
        //Q10
        ListQuestion.add(Question(
            10,
            "Một địa chỉ email đầy đủ tồn tại trên mạng internet là một địa chỉ?",
            "Duy nhất không trùng với bất kỳ người nào trong mạng",
            "Có thể trùng trên cùng một máy chủ",
            "Có thể trùng nhưng khác máy chủ",
            "Mỗi người chỉ có duy nhất 1 địa chỉ email như địa chỉ đăng ký nhà",
            4
        ))
        return ListQuestion
    }
}