public class TestClass {
    public static void main(String[] args) {

        MessageService smsService  = new SMSService();
        smsService.sendMsg("test");


        MessageService  twitterService = new TwitterService();
        twitterService.sendMsg("sample");

    }
}
