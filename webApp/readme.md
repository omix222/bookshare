# Demoアプリケーション

## DBのセットアップ(H2(インメモリDB）)

- テーブルの作成などは特に不要（Java側から自動生成される）

- DBを参照、データ投入される場合はブラウザから以下URLにアクセスする
- http://localhost:8080/h2-console/login.jsp
	- 設定は以下
	- Saved SettingsとSetting Nameは変更不要
	- Driver Class, User Name, Passwordはapplication.propertiesに記載の内容を設定する
		- デフォルトの設定は、それぞれ、org.h2.Driver,user,pass
	- JDBC URLについては、以下を参考にh2コロンのあとはSTSプロジェクト直下のtestdb.mv.dbのパスの拡張子無しの形で設定する
		- 例：　jdbc:h2:~/oper/bookshare/webApp/testdb

## 画面URL一覧
- 書籍一覧表示&貸し出し受付画面
	- http://localhost:8080/stocklist
- 書籍登録画面
	- http://localhost:8080/bookregist
- ログイン後のブラウザで強制ログアウトするURL
	- http://localhost:8080/login?logout