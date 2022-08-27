import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;

public class WeiXin_Push {
    public static void main(String[] args) {
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
//        wxMpService.getTemplateMsgService().sendTemplateMsg();
//        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
    }

    public static int testing() {
        return 1;
    }
}
