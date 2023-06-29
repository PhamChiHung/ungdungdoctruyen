package com.example.ungdungdoctruyen.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import com.example.ungdungdoctruyen.model.TaiKhoan;
import com.example.ungdungdoctruyen.model.Truyen;

public class databasedoctruyen extends SQLiteOpenHelper {
    //CSDL
    //tên database
    private static String DATABASE_NAME = "doctruyen";
    //biến bảng tài khoản
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 1;

    //biến bảng truyện
    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";


    private Context context;
    //biến lưu câu lệnh tạo bảng tài khoản
    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";
    //biến lưu câu lệnh tạo bảng truyện
    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";
    //Insert dữ liệu vào bảng tài khoản
    //phân quyền admin và ng dùng
    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'admin','admin','admin@gmail.com',2)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'hung','hung','hung@gmail.com',1)";
    //Insert truyện
    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Rùa và Thỏ','Phần 1:\n" +
            "\n" +
            "Ngày xửa ngày xưa, có một con Rùa và một con Thỏ sống trong một khu rừng xinh đẹp và yên tĩnh. Ngày ngày chúng vui chơi với nhau như hai người bạn thân. Một hôm, Thỏ và Rùa cãi nhau xem ai nhanh hơn. Rồi chúng quyết định giải quyết việc tranh luận bằng một cuộc thi chạy đua. Thỏ và Rùa đồng ý lộ trình và bắt đầu cuộc đua. Thỏ xuất phát nhanh như tên bắn và chạy thục mạng rất nhanh, khi thấy rằng mình đã khá xa Rùa, Thỏ nghĩ nên nghỉ cho đỡ mệt dưới một bóng cây xum xuê lá bên vệ đường. Vì quá tự tin vào khả năng giành chiến thắng của mình, Thỏ ngồi dưới bóng cây và nhanh chóng ngủ thiếp đi. Rùa chạy mãi rồi cũng đến nơi, thấy Thỏ đang ngủ ngon giấc Rùa từ từ vượt qua Thỏ và về đích trước Thỏ. Khi Thỏ thức dậy thì rùa đã đến đích và trở thành người chiến thắng. Lúc này Thỏ biết mình đã thua cuộc vì quá tự tin vào khả năng của mình, còn Rùa chiến thắng vì kiên trì bám đuổi mục tiêu và làm việc hết sức trong khả năng của mình, cộng với một chút may mắn và giành chiến thắng.\n" +
            "\n" +
            "Ý nghĩa câu chuyện phần 1: truyện giáo dục đức tính kiên trì, siêng năng, nhẫn nại. Những người nhanh nhẹn nhưng cẩu thả trong suy nghĩ cuối cùng cũng sẽ bị đánh bại bởi người kiên nhẫn, siêng năng dù họ chậm hơn rất nhiều.\n" +
            "\n" +
            "Phần 2:\n" +
            "\n" +
            "Thỏ vô cùng thất vọng vì để thua Rùa, nó nhận ra rằng nó thua chính vì quá tự tin, bất cẩn và thiếu kỷ luật. Nếu nó không xem mọi thứ quá dễ dàng và chắc thắng thì rùa không thể có cơ hội hạ được nó. Vì thế, Thỏ quyết định thách thức Rùa bằng một cuộc đua mới. Rùa đồng ý. Lần này, Thỏ chạy với tất cả sức lực của nó và chạy một mạch về đích. Nó bỏ xa Rùa đến mấy dặm đường.\n"+
            "Ý nghĩa câu chuyện phần 2: Biết sai và sửa sai là một đức tính tốt, đó chính là lý do giúp anh chàng thỏ giành được chiến thắng ở cuộc đua thứ 2. Mẹ hãy giải thích cho bé hiểu rằng trong công việc hàng ngày giữa một người chậm, cẩn thận và đáng tin cậy với một người nhanh nhẹn, đáng tin cậy, chắc chắn người nhanh nhẹn sẽ được trọng dụng hơn nhiều và họ sẽ tiến xa hơn trong học tập, cũng như trong cuộc sống. Cha mẹ hãy giúp bé hiểu rõ thông điệp chậm và chắc là điều tốt, nhưng nhanh và đáng tin cậy sẽ tốt hơn rất nhiều.','https://toplist.vn/images/800px/rua-va-tho-230179.jpg',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Củ cải trắng','Mùa đông đã đến rồi trời lạnh buốt, Thỏ con không có gì để ăn cả. Thỏ con mặc áo vào rồi ra ngoài kiếm thức ăn. Nó đi mãi đi mãi cuối cùng cũng tìm được hai củ cải trắng. Thỏ con reo lên:\n" +
            "\n" +
            "– Ôi, ở đây có hai củ cải trắng liền, mình thật là may mắn!\n" +
            "\n" +
            "Thỏ con đói bụng, muốn ăn lắm rồi. Nhưng Thỏ lại nghĩ:\n" +
            "\n" +
            "– Ừm… trời lạnh thế này, chắc Dê con cũng không có cái gì để ăn đâu. Mình phải mang cho Dê con một củ mới được.\n" +
            "\n" +
            "Thế là Thỏ con đi sang nhà bạn Dê nhưng Dê con không có nhà nên Thỏ đặt củ cải lên bàn rồi đi về.\n" +
            "\n" +
            "Tình cờ, Dê con đi chơi cũng tìm được một củ cải trắng nhưng nó chỉ ăn trước một nửa.\n" +
            "\n" +
            "Về đến nhà, lại thấy có một củ cải trắng ở trên bàn Dê thèm ăn lắm, nhưng lại nghĩ:\n" +
            "\n" +
            "– Ôi trời lạnh thế này chắc Hươu con không có cái gì để ăn rồi, mình phải mang cho Hươu con mới được.\n" +
            "\n" +
            "Dê con đến nhà Hươu nhưng Hươu lại đi vắng, Dê con bèn đặt củ cải ở trên bàn rồi về.\n" +
            "\n" +
            "Khi Hươu về nhà, thấy củ cải ở trên bàn, Hươu ngạc nhiên lắm.\n" +
            "\n" +
            "– Ồ, củ cải trắng ở đâu mà ngon vậy nhỉ. Xuỵt… thích quá. Nhưng chắc trời lạnh thế này, Thỏ con cũng không có gì ăn đâu. Mình phải mang sang cho Thỏ mới được.\n" +
            "\n" +
            "Khi Hươu đến thì Thỏ con đang ngủ rất say. Khi tỉnh dậy Thỏ lại thấy trên bàn mình xuất hiện một củ cải trắng.Thỏ vui lắm nó chạy đi gọi các bạn:\n" +
            "\n" +
            "– Bạn Hươu ơi, bạn Dê ơi hãy đến nhà tôi, chúng ta cùng ăn củ cải trắng thơm ngon này.\n" +
            "\n" +
            "Thế là cuối cùng, củ cải trắng ấy được chia sẻ cho cả ba người bạn tốt bụng của chúng ta. Các bạn thấy đấy tấm lòng thơm thảo, sẵn sàng sẻ chia của các bạn ấy thật là đáng học tập phải không nào?\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Khi cho đi bạn sẽ nhận lại được nhiều hơn những thứ mình có.','https://toplist.vn/images/800px/cu-cai-trang-230181.jpg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'Dê đen và dê trắng','Dê đen và Dê trắng cùng sống trong một khu rừng. Hàng ngày, cả hai thường đến uống nước và tìm cái ăn ở trong khu rừng quen thuộc.\n" +
            "\n" +
            "Một hôm, Dê trắng đi tìm cái ăn và uống nước suối như mọi khi. Dê đang mải mê ngặm cỏ, bất chợt một con Sói ở đâu nhảy xổ ra. Sói quát hỏi:\n" +
            "\n" +
            "- Dê kia! Mi đi đâu?\n" +
            "\n" +
            "Dê trắng sợ rúm cả người, lắp bắp:\n" +
            "\n" +
            "– Dạ, dạ, tôi đi tìm… tìm cỏ non và…và uống nước suối ạ!\n" +
            "\n" +
            "Sói lại quát hỏi:\n" +
            "\n" +
            "– Mi có gì ở chân?\n" +
            "\n" +
            "– Dạ, dạ, chân của tôi có móng ạ…ạ!\n" +
            "\n" +
            "– Trên đầu mi có gì?\n" +
            "\n" +
            "– Dạ, dạ, trên đầu tôi có đôi sừng mới nhú…\n" +
            "\n" +
            "Sói càng quát to hơn:\n" +
            "\n" +
            "– Trái tim mi thế nào?\n" +
            "\n" +
            "– Ôi, ôi, trái…trái tim tôi đang run sợ…sợ…\n" +
            "\n" +
            "– Hahaha…\n" +
            "\n" +
            "Sói cười vang rồi ăn thịt chú Dê trắng tội nghiệp\n" +
            "\n" +
            "Dê đen cũng đi tới khu rừng để ăn cỏ non và uống nước suối. Đang tha thẩn ngặm cỏ, chợt Sói xuất hiện, nó quát hỏi:\n" +
            "\n" +
            "– Dê kia, mi đi đâu?\n" +
            "\n" +
            "Dê đen nhìn con Sói từ đầu tới chân rồi ngước cổ trả lời:\n" +
            "\n" +
            "– Ta đi tìm kẻ nào thích gây sự đây!\n" +
            "\n" +
            "Sói bị bất ngờ, nó hỏi tiếp:\n" +
            "\n" +
            "– Thế dưới chân mi có gì?\n" +
            "\n" +
            "– Chân thép của ta có móng bằng đồng.\n" +
            "\n" +
            "– Thế…thế…trên đầu mi có gì?\n" +
            "\n" +
            "– Trên đầu của ta có đôi sừng bằng kim cương!\n" +
            "\n" +
            "Sói sợ lắm rồi, nhưng vẫn cố hỏi:\n" +
            "\n" +
            "– Mi…mi…trái tim mi thế nào?\n" +
            "\n" +
            "Dê đen dõng dạc trả lời:\n" +
            "\n" +
            "– Trái tim thép của ta bảo ta rằng: hãy cắm đôi sừng kim cương vào đầu Sói. Nào, Sói hãy lại đây.\n" +
            "\n" +
            "Ôi trời, sợ quá, con Sói ba chân bốn cẳng chạy biến vào rừng, từ đó không ai trông thấy nó lởn vởn ở khu rừng đó nữa.\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Qua câu chuyện ngụ ngôn trên, bạn có thể truyền tải nhiều thông điệp khác nhau cho bé hiểu. Chẳng hạn như biết cách ứng xử trước các tình huống khó, nguy hiểm, lạc quan và bản lĩnh để xử lý vấn đề.','https://toplist.vn/images/800px/de-den-va-de-trang-230182.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'Chú bé chăn cừu','Một chú bé chăn cừu cho chủ thả cừu gần một khu rừng rậm cách làng không xa lắm. Chăn cừu được ít lâu, chú cảm thấy công việc chăn cừu thực là nhàm chán. Tất cả mọi việc chú có thể làm để giải khuây là nói chuyện với con chó hoặc thổi chiếc sáo chăn cừu của mình.\n" +
            "\n" +
            "Một hôm, trong lúc đang ngắm nhìn đàn cừu và cánh rừng yên tĩnh chú bé chợt nhớ tới lời chủ của chú từng dặn rằng khi sói tấn công cừu thì phải kêu cứu để dân làng nghe thấy và đánh đuổi nó đi.\n" +
            "\n" +
            "Thế là chú nghĩ ra một trò chơi cho đỡ buồn. Mặc dù chẳng thấy con sói nào, chú cứ chạy về làng và la to:\n" +
            "\n" +
            "– Sói ! Sói !\n" +
            "\n" +
            "Đúng như chú nghĩ, dân làng nghe thấy tiếng kêu bỏ cả việc làm và tức tốc chạy ra cánh đồng. Nhưng khi đến nơi, họ chẳng thấy sói đâu, chỉ thấy chú bé ôm bụng cười ngặt nghẽo vì đã lừa được họ.\n" +
            "\n" +
            "Ít ngày sau chú bé chăn cừu lần nữa lại la lên:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Và một lần nữa dân làng lại chạy ra giúp chú. Nhưng họ lại chẳng thấy con sói nào, chỉ thấy chú bé chăn cừu nghịch ngợm ôm bụng cười khoái chí.\n" +
            "\n" +
            "Thế rồi vào một buổi chiều nọ, khi mặt trời lặn xuống sau cánh rừng và bóng tối bắt đầu phủ đầy lên cánh đồng, một con sói thực sự xuất hiện. Nó nấp sau bụi cây rình bắt những con cừu béo non. Bỗng sói phóng vút ra chộp lấy một chú cừu tội nghiệp. Thấy sói cả đàn cừu sợ hãi chạy toán loạn, chú bé chăn cừu cũng hoảng loạn vô cùng.\n" +
            "\n" +
            "Quá hoảng sợ, chú bé chăn cừu vội chạy về làng và la to:\n" +
            "\n" +
            "– “Sói ! Sói !”.\n" +
            "\n" +
            "Nhưng mặc dù dân làng có nghe tiếng chú kêu, không một ai chạy ra để giúp chú như những lần trước cả. Vì mọi người nghĩ chú lại bày trò nói dối như trước.\n" +
            "\n" +
            "Thế là sói thỏa sức bắt mồi, giết chết rất nhiều cừu của chú bé. Sau khi đã chén no nê, nó biến mất vào rừng rậm. Chú bé buồn bã ngồi giữa đồng cỏ, lòng đầy hối hận về hành động nói dối của mình và hậu quả của trò đùa dại dột gây ra.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Nói dối là một tật xấu. Người hay nói dối ngay cả khi nói thật cũng không ai tin.','https://toplist.vn/images/800px/chu-be-chan-cuu-230183.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Cậu bé chăn cừu và cây đa cổ thụ','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://toplist.vn/images/800px/cau-be-chan-cuu-va-cay-da-co-thu-230184.jpg',1)";

    private String SQLQuery9 = "INSERT INTO truyen VALUES (null,'Con cú khôn ngoan','Ngày xửa ngày xưa, có một con cú già sống trên một cây sồi to. Mỗi ngày, nó đều phóng tầm mắt ra thật xa để quan sát những điều xảy ra xung quanh mình. Có khi nó nhìn thấy một cậu bé đang giúp ông lão xách một cái túi to, có khi nó nhìn thấy một cô con gái đang cằn nhằn mẹ mình. Ngày qua ngày, con cú nhìn thấy được rất nhiều thứ nhưng nó vẫn giữ im lặng về những điều mà mình thấy.\n" +
            "\n" +
            "Từ từ, con cú già bắt đầu nói ít hơn và thính giác của nó dần trở nên tốt hơn. Bây giờ nó có thể nghe rõ những cuộc nói chuyện của mọi người. Một ngày, con cú già nghe thấy một người phụ nữ nói với ai đó rằng có một con voi nhảy qua hàng rào. Một ngày khác, con cú lại nghe thấy một người đàn ông nói với ai đó rằng mình là con người hoàn hảo và chưa bao giờ mắc phải sai lầm gì.\n" +
            "\n" +
            "Mỗi ngày trôi qua, con cú già lại nói ít hơn và nghe nhiều hơn. Nhờ vậy, nó biết được tất cả mọi thứ xảy ra xung quanh, dù không có ở đó. Dần dần, con cú già trở nên khôn ngoan hơn và nổi tiếng vì sự khôn ngoan ấy.\n" +
            "\n" +
            "Ý nghĩa của câu chuyện khi bạn kể chuyện bé nghe: Nói ít, quan sát và lắng nghe nhiều sẽ giúp con trở nên thông minh và khôn ngoan hơn.','https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-2-e1511109071378.jpg',1)";
    private String SQLQuery10 = "INSERT INTO truyen VALUES (null,'Chó sói và đàn dê','Ngày xửa ngày xưa, ở một khu rừng nọ có một con dê mẹ và 7 chú dê con. Họ sống với nhau hạnh phúc trong một ngôi nhà nho nhỏ, xinh xắn và ấm cúng.\n" +
            "\n" +
            "Dê mẹ thường phải vào rừng để tìm cỏ non, vì ăn cỏ no thì dê mẹ mới có sữa cho đàn dê con bú. Một hôm, khi chuẩn bị đi vào rừng, dê mẹ bèn gọi đàn con lại dặn dò: ”Các con ở nhà nhớ khóa chặt cửa. Khi nào mẹ về, nghe thấy mẹ đọc bài thơ này thì hẵng mở cửa ra:\n" +
            "\n" +
            "\n" +
            "Dê con ngoan ngoãn.\n" +
            "\n" +
            "Mau mở cửa ra.\n" +
            "\n" +
            "Mẹ đã về nhà.\n" +
            "\n" +
            "Cho các con bú.”\n" +
            "\n" +
            "\n" +
            "7 chú dê con vâng lời mẹ đóng chặt cửa. Thế nhưng, có một con chó sói độc ác sống ở gần đó đã nghe thấy lời dặn của dê mẹ. Sau một hồi tính toán, nó nảy ra ý định lừa dê con mở cửa để ăn thịt các chú.\n" +
            "\n" +
            "Sau khi dê mẹ đi khỏi, chó sói liền đến gõ cửa rồi giả giọng dê mẹ:\n" +
            "\n" +
            "\n" +
            "Dê con ngoan ngoãn.\n" +
            "\n" +
            "Mau mở cửa ra.\n" +
            "\n" +
            "Mẹ đã về nhà.\n" +
            "\n" +
            "Cho các con bú.”\n" +
            "\n" +
            "\n" +
            "Bảy chú dê con nhận ra giọng ồm ồm của chó sói nên đã nhất quyết không mở cửa.\n" +
            "\n" +
            "Một lúc sau, chó sói lại đến và gõ cửa. Lần này nó giả giọng nhẹ nhàng hơn cho giống với giọng dê mẹ. Nhưng lần này, nó cũng không vào đươc ngôi nhà vì những chú dê con thông minh đã đòi sói phải cho xem móng. Khi thấy móng chân đen xì của con sói, các chú đã không cho nó vào.\n" +
            "\n" +
            "Chó sói nham hiểm liền đến tiệm bánh mua bột mỳ trắng và xoa vào móng vuốt của mình.\n" +
            "\n" +
            "Khi nó đến gõ cửa lần thứ ba, những chú dê con nhìn thấy bộ móng màu trắng và cứ tưởng rằng đó là mẹ của mình. Dê con mở cửa cho sói vào nhà và nó lao đến và nuốt chửng cả bầy dê vào bụng; may thay chú dê bé nhất trốn thoát đươc. No nê, con sói độc ác tìm một gốc cây rồi lăn ra ngủ. Khi ấy, dê mẹ trở về và chú dê bé nhất nhào vào lòng mẹ nức nở.\n" +
            "\n" +
            "Dê mẹ liền mổ bụng sói ra. Lần lượt từng chú dê con nhảy ra. Dê mẹ bảo dê con lấy đá nhét vào bụng sói và khâu lại. Khi chó sói tỉnh dậy nó cảm thấy vô cùng khát nước, nó lần mò ra giếng uống nước.\n" +
            "\n" +
            "Vì trong bụng nặng trĩu toàn đá là đá nên nó bị rơi tòm xuống giếng. Thế là hết đời con sói gian ác.”\n" +
            "\n" +
            "Ý nghĩa: Sẽ có những kẻ gian, người xấu tìm mọi cách để dụ dỗ, gây hại cho bé. Truyện cổ tích cho bé ngủ ngon này động viên các bé nghe lời cha mẹ để có thể đảm bảo an toàn cho chính mình.','https://cdn.marrybaby.vn/wp-content/uploads/2017/10/11/ke-chuyen-cho-be-ngu-5.jpg',1)";
    private String SQLQuery11 = "INSERT INTO truyen VALUES (null,'Chú chồn lười học','“Chồn mướp sống ở khu rừng thông, vì là con một nên cậu được cha mẹ cưng chiều vô cùng. Tới tuổi đi học rồi, nhưng chồn mướp vẫn không chịu đến trường; chỉ rong chơi mà thôi. Vì được nuông chiều quá, chồn mướp đâm ra bướng bỉnh, không chịu nghe lời ai. Ai khuyên gì cậu cũng không nghe mà còn cãi bướng.\n" +
            "\n" +
            "Một hôm, Chồn mải chơi, bị lạc vào sâu trong rừng mà không biết đường ra. Cậu ta lang thang mãi mới tìm được bảng chỉ đường. Nhưng khổ nỗi, không biết chữ nên chồn không đọc được.\n" +
            "\n" +
            "\n" +
            "Cậu ngồi xuống vừa khóc vừa hối hận; nếu chịu khó đi học biết chữ thì bây giờ đâu phải như thế này. Đúng lúc đó thì bác sư tử xuất hiện; chồn tưởng mình sắp bị ăn thịt nên quỳ lạy xin tha mạng.\n" +
            "\n" +
            "Bác sư tử bảo: “Ta chỉ muốn giúp cháu thôi, vì cháu không biết chữ chứ gì?” Chồn gật đầu. Được bác sư tử khuyên răn và chỉ đường; chồn đã tìm về được ngôi nhà của mình. Chú mừng lắm và nhất quyết từ nay phải đi học”.\n" +
            "\n" +
            "Ý nghĩa: Các bé cần học hành chăm chỉ; trang bị kiến thức để có thể hòa nhập với cuộc sống.','https://cdn.marrybaby.vn/wp-content/uploads/2021/10/truyen-co-tich-cho-be-ngu-ngon_009.png',1)";
    private String SQLQuery12 = "INSERT INTO truyen VALUES (null,'Bài học đầu tiên của Gấu con','“Ngày chủ nhật Gấu con xin phép mẹ ra đường chơi cùng các bạn. Gấu mẹ dặn: “Con chơi ngoan nhé. Nếu làm sai điều gì, con phải xin lỗi. Được ai giúp đỡ thì con phải cảm ơn.”\n" +
            "\n" +
            "Gấu con tung tăng chạy nhảy và mải lắng nghe chim Sơn Ca hót nên va phải bạn Sóc khiến giỏ nấm văng tung toé ra đất. Gấu con vội vàng khoanh tay và lễ phép nói: “Cảm ơn bạn Sóc!” Nói xong Gấu con cúi xuống nhặt nấm bỏ vào giỏ giúp Sóc.\n" +
            "\n" +
            "\n" +
            "Sóc ngạc nhiên nói: “Sao Gấu con lại cảm ơn, phải nói xin lỗi chứ!”\n" +
            "\n" +
            "Mải nhìn Khỉ mẹ ngồi chải lông cho Khỉ con nên Gấu con bị trượt chân, rơi xuống hố sâu. Gấu con sợ quá kêu thất thanh: “Cứu tôi với! Ai cứu tôi !!!”\n" +
            "\n" +
            "Bác Voi ở đâu đi tới liền đưa vòi xuống hố và nhấc bổng Gấu con lên mặt đất. Gấu con luôn miệng: “Cháu xin lỗi bác Voi, Cháu xin lỗi bác Voi!”\n" +
            "\n" +
            "Bác Voi cũng rất ngạc nhiên liền nói: “Sao Gấu con lại xin lỗi, phải nói cảm ơn chứ!”\n" +
            "\n" +
            "\n" +
            "Về nhà, Gấu con kể lại chuyện cho mẹ nghe. Gấu mẹ ôn tồn giảng giải: “Con nói như vậy là sai rồi. Khi làm đổ nấm của bạn Sóc, con phải xin lỗi. Còn khi bác Voi cứu con ra khỏi hố sâu, con phải cảm ơn.” “Con nhớ rồi ạ!” – Gấu con vui vẻ nói.”\n" +
            "\n" +
            "Ý nghĩa: Truyện cổ tích cho bé tập đi ngủ ngon này sẽ giúp bé biết khi làm sai phải xin lỗi; khi được giúp đỡ phải cảm ơn.','https://cdn.marrybaby.vn/wp-content/uploads/2021/10/truyen-co-tich-cho-be-ngu-ngon-009.jpg',1)";
    private String SQLQuery13 = "INSERT INTO truyen VALUES (null,'Đeo chuông cho mèo','“Trong một cửa hàng bách hóa nọ có rất nhiều chuột. Hằng ngày, chúng phá phách và làm hư hỏng rất nhiều hàng hóa. Vì vậy, chủ tiệm đã quyết định mua một con mèo để dẹp yên lũ chuột này. Đàn chuột rất lo lắng về điều đó và tìm cách tự cứu lấy mình.\n" +
            "\n" +
            "Một con chuột đứng dậy và nói: “Tôi có kế hoạch này, nếu chúng ta đeo một cái chuông vào cổ của con mèo; mọi cử động của nó, chúng ta đều biết được”. Đây cũng là một ý kiến hay, thế nhưng vấn đề được đặt ra là ai sẽ làm điều đó. Và khi câu hỏi này được nêu lên, không một ai đáp lại.”\n" +
            "\n" +
            "\n" +
            "Ý nghĩa: Truyện cổ tích cho bé ngủ ngon này cho thấy giải pháp không hiệu quả sẽ là một sự lãng phí thời gian.','https://cdn.marrybaby.vn/wp-content/uploads/2021/10/truyen-co-tich-cho-be-ngu-ngon_0010.jpg',1)";
    private String SQLQuery14 = "INSERT INTO truyen VALUES (null,'Sự tích cây vú sữa','Ngày xưa, có một cậu bé được mẹ cưng chiều nên rất nghịch và ham chơi, không nghe lời mẹ. Một lần, bị mẹ mắng, cậu giận mẹ bỏ đi. Cậu la cà, dạo chơi khắp nơi, mẹ cậu ở nhà không lo lắng biết cậu ở đâu nên rất buồn. Bà ngày ngày mẹ ngồi ở bậc cửa ngóng con trở về.\n" +
            "\n" +
            "Thời gian trôi qua mà cậu vẫn không về. Vì quá đau buồn và kiệt sức, mẹ cậu mất. Không biết cậu đã đi bao lâu. Một hôm, vừa đói vừa rét, lại bị trẻ lớn hơn đánh, cậu mới nhớ đến mẹ.\n" +
            "\n" +
            "– Phải rồi, khi mình đói, mẹ vẫn cho mình ăn, khi mình bị đứa khác bắt nạt, mẹ vẫn bảo vệ mình, về với mẹ thôi.\n" +
            "\n" +
            "Cậu vội tìm đường về nhà. Ở nhà, cảnh vật vẫn như xưa, nhưng không thấy mẹ đâu. Cậu gọi mẹ:\n" +
            "\n" +
            "– Mẹ ơi, mẹ đi đâu rồi, con đói quá ! – Cậu gục xuống, ôm một cây xanh trong vườn mà khóc.\n" +
            "\n" +
            "Kỳ lạ thay, cây xanh đó bỗng run rẩy. Từ các cành lá, những đài hoa be bé trổ ra, nở trắng như mây. Hoa tàn, quả xuất hiện, lớn nhanh, da căng mịn, xanh óng ánh. Cây nghiêng cành, một quả to mọng rơi vào tay cậu bé.\n" +
            "\n" +
            "Cậu bé cắn một miếng thật to, câu thốt lên: “Chát quá!”\n" +
            "\n" +
            "Quả thứ hai rơi xuống. Cậu lột vỏ, cắn vào hạt quả. Cậu thốt lên: “Cứng quá!”\n" +
            "\n" +
            "Quả thứ ba rơi xuống. Cậu khẽ bóp quanh quanh quả, lớp vỏ mềm dần rồi khẽ nứt ra một kẻ nhỏ. Một dòng sữa trắng sóng sánh trào ra, ngọt thơm như sữa mẹ.\n" +
            "\n" +
            "Cậu bé ghé môi hứng lấy dòng sữa ngọt ngào, thơm ngon như sữa mẹ.\n" +
            "\n" +
            "Cây rung rinh cành lá, thì thào: “Ăn trái ba lần mới biết trái ngon. Con có lớn khôn mới hay lòng mẹ.”\n" +
            "\n" +
            "\n" +
            "Cậu oà lên khóc. Mẹ đã không còn nữa. Cậu nhìn lên tán lá, lá một mặt xanh bóng, mặt kia đỏ hoe như mắt mẹ khóc chờ con. Cậu ôm lấy thân cây mà khóc, thân cây xù xì, thô ráp như đôi bàn tay làm lụng của mẹ.\n" +
            "\n" +
            "Nước mắt cậu rơi xuống gốc cây. Cây xòa cành ôm cậu, rung rinh cành lá như tay mẹ âu yếm vỗ về đứa con thân yêu. Cậu kể cho mọi người nghe chuyện về người mẹ và nỗi ân hận của mình.\n" +
            "\n" +
            "Ý nghĩa: Lòng hiếu thảo là phẩm chất cao đẹp của con người, là thước đo nhân phẩm và giá trị. Truyện cổ tích cho bé ngủ ngon này cho thấy tình mẹ luôn thiêng liêng và cao cả; do đó, bé phải học cách biết ơn.','https://cdn.marrybaby.vn/wp-content/uploads/2021/10/truyen-co-tich-cho-be-ngu-ngon_0011.jpg',1)";
    private String SQLQuery15 = "INSERT INTO truyen VALUES (null,'Vịt con cẩu thả','“Hôm đó trời đẹp, Vịt con ra sông chơi. Theo thói quen, nó cởi quần áo ra bỏ lung tung trên bờ mà không để cho gọn gàng, rồi nhảy ùm xuống nước bơi thỏa thích. Vì vứt khắp nơi nên lát sau quần áo bị nước cuốn trôi đi hết cả mà vịt con chẳng hề hay biết.\n" +
            "\n" +
            "Bơi thật vui xong vịt con lên bờ thì không thấy quần áo đâu nữa. Làm sao về nhà được bây giờ, vịt con òa lên khóc. Nhìn xung quanh, vịt con thấy có mấy chiếc lá sen to, nó bèn nghĩ ra cách ngắt lá sen che đỡ lên người để về nhà.\n" +
            "\n" +
            "Vịt con vừa ôm lá sen trước ngực vừa chạy về nhà. Chạy ngang bãi cỏ thì Thỏ nhìn thấy, nó phá lên cười.\n" +
            "\n" +
            "– Lêu lêu xấu hổ. Để hở cả mông. Mà chạy lông nhông.\n" +
            "\n" +
            "Vịt con nghe thế, biết là Thỏ hát trêu mình, xấu hổ đến đỏ cả mặt. Khi Vịt con đi qua rừng, lại nghe thấy tiếng hát của Khỉ trên cây:\n" +
            "\n" +
            "– Gió thổi, lá sen bay. Để cả mông ra ngoài.\n" +
            "\n" +
            "Vịt con lại càng xấu hổ khóc to hơn. Về đến nhà, Vịt con kể đầu đuôi cho mẹ nghe, mẹ nó không nhị được cười nói:\n" +
            "\n" +
            "– Từ nay con nhớ phải bỏ thói quen để quần áo lung tung nhé!\n" +
            "\n" +
            "Vịt con “Vâng ạ” rõ to rồi đi mặc quần áo.”\n" +
            "\n" +
            "Ý nghĩa: Bé cần tập cho mình tính ngăn nắp, gọn gàng, không vứt đồ đạc bừa bãi.','https://cdn.marrybaby.vn/wp-content/uploads/2021/10/truyen-co-tich-cho-be-ngu-ngon_0014.jpg',1)";
    //tạo bảng ở phương thức này
    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //thực hiện các câu lệnh truy vấn không trả về kq
        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery9);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery11);
        db.execSQL(SQLQuery12);
        db.execSQL(SQLQuery13);
        db.execSQL(SQLQuery14);
        db.execSQL(SQLQuery15);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ) {

    }
    //Phương thức lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_TAIKHOAN,null);
        return res;
    }

    //phương thức add tài khoản vào database
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db =this.getWritableDatabase();

        //Thực hiện insert thông qua ContentValues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        db.close();
        Log.e("ADD TK ", "TC");
    }

    //Lấy 3 truyện mới nhất
    public Cursor getData1(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" DESC LIMIT 5",null);
        return res;
    }

    //lấy tất cả truyện
    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM " +TABLE_TRUYEN,null);
        return res;
    }

    //Add truyện
    public void  AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
    }

    //delete truyện
    public int Delete(int i){
        SQLiteDatabase db =  this.getReadableDatabase();
        int res = db.delete(TABLE_TRUYEN,ID_TRUYEN+" = "+i,null);
        return res;
    }
}
