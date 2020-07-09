# servlet-learning
これはServletの学習用のプロジェクトです。
Eclipseを使用します。

- /WebServ_Dev//HelloWorldServlet/  : ルーティングデモ
- /WebServ_Dev/                     : GET・POSTデモ(ディスパッチ含む)
- /WebServ_Dev/CookieSession/       : Cookie・Sessionデモ
- encodeFilterクラス                 : Filterデモ

# Servlet開発
参考： http://web.javastudy.biz/

1. 動的Web
2. ランタイム指定
   1. 新規Tomcatインストール
   2. tomcatフォルダ指定
3. サーブレット作成
4. サーブレットを指定しサーバーで実行（ランタイムは指定したものになっている）

web.xmlはあるとむしろエラーになりがち

## フィルター

```
@WebFilter("/*")
implements Filter ⇒doFilter()
```

## サーブレット間連携
参考：https://www.javadrive.jp/servlet/dispatch/

### インクルード ：ServA ⇒ ServB ⇒ ServA

```
・・・
String disp = "/includetest";
RequestDispatcher dispatch = request.getRequestDispatcher(disp);

dispatch.include(request, response);
・・・
```

### フォワード ：次のサーブレットに処理を移す

```
・・・
String disp = "/forwardtest";
RequestDispatcher dispatch = request.getRequestDispatcher(disp);

dispatch.forward(request, response);
```

### リダイレクト ：クライアントに次の場所を見に行くように命令

```
String url = "/dispatch/redirecttest";

response.sendRedirect(url);
```

### データ連携

```
request.setAttribute("Hantei", "Out");

String disp = "/forwardtest";
RequestDispatcher dispatch = request.getRequestDispatcher(disp);

dispatch.forward(request, response);
```

```
String hantei = (String)request.getAttribute("hantei");
```

## ユーザ認証
https://www.javadrive.jp/servlet/auth/

## cookie

```
Cookie cook = new Cookie("Cookie", "I'm from cookie!");
cook.setMaxAge(60*60*24);
response.addCookie(cook);
```

```
<%
Cookie[] cookies = request.getCookies();
String coo = "";
if (cookies != null) {
    for (Cookie cook : cookies) {
        if (cook.getName().equals("Cookie")) {
            coo = cook.getValue();
        }
    }
}
%>
```

## session

```
HttpSession session = request.getSession();
String sessionId = session.getId();
session.setAttribute("SessionId", sessionId);
```

```
String sessionId = (String)session.getAttribute("SessionId");
```

## デプロイ
Tomcat参考：https://itsakura.com/tomcat-warfile
Apache参考：https://www.adminweb.jp/apache/tomcat/

# テスト

```
public class Model {
    public static String appendMr(String name) {
        return "Mr." + name;
    }
}
```

```
public class SampleTest {
    @Test
    public void testAppendMr() throws Exception {
        String name = Model.appendMr("sato");
        assertEquals("Mr.sato", name);
    }
}
```
Eclipseではクラス内でTestと書いてCtrl+spaceでJUnitのビルドパス構成、importまでやってくれる。

Testファイルを選択し、実行＞JUnitで実行から結果が見れる。assertが成功なら緑、ダメならソースに飛べる。

## javadoc生成
```
/**
 * javadocはこう書く。
 *
 */
```
ファイル＞エクスポート＞Javadocから生成、デフォルトではプロジェクト内にHTMLが作られる。