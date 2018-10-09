# Demoアプリケーション

## SpringFoxを使って、Swagger UI生成しています

 - 下記URLで各APIの仕様を確認することができます
 - http://localhost:8080/swagger-ui.html

 - 下記URLでswagger yamlも取得可能です。
 - http://localhost:8080/v2/api-docs?group=public

## DBのセットアップ(H2(インメモリDB）)

- テーブルの作成などは特に不要（Java側から自動生成される）

- DBを参照、データ投入される場合はブラウザから以下URLにアクセスする
- http://localhost:8080/h2-console/login.jsp
	- 設定は以下
	- Saved SettingsとSetting Nameは変更不要
	- Driver Class, User Name, Passwordはapplication.propertiesに記載の内容を設定する
		- デフォルトの設定は、それぞれ、org.h2.Driver,user,pass
	- JDBC URLについては、以下を参考にh2コロンのあとはSTSプロジェクト直下のtestdb.mv.dbのパスの拡張子無しの形で設定する
		- 例：　jdbc:h2:~/oper/spring-study-sample/immem/spring-study-sample/testdb

- H2コンソール上から、以下SQLを実行し、データを投入する

- INSERT INTO T_EMPLOYEE(ID, NAME, DEPARTMENT_NAME) VALUES('id002','SEKI YU','JFW');

### RESTAPIのcurl実行例

- curl -i -X POST -H "Content-Type:application/json" -d '{"id": "book001", "title": "PoEAA" , "tags":"アーキテクチャ","publisher":"??"}' http://localhost:8080/api/books

- curl -i -X GET -H "Content-Type:application/json" http://localhost:8080/api/books
