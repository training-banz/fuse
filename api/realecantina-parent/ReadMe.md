NG
http://localhost:9091/realecantina/winery
http://localhost:9092/api-docs

OK
http://localhost:9091/realecantina/rest/winery/all
http://localhost:9091/realecantina/rest/winery?taste=フルボディ
http://localhost:9091/realecantina/rest/winery?taste=エレガント
http://localhost:9091/realecantina/rest/api-docs

curl http://localhost:9091/realecantina/rest/api-docs/myCamel/swagger.json

wagggerとwaggger-uiの関連
2.0=>2.2.5
http://swagger.io/docs/swagger-tools/#swagger-ui-documentation-29


log4jのプロパティファイルは必要、ないと起動できない 途中で止まる
今回のblueprint.xmlでは同一フォルダに複数あると、JMXにかんする例外が発生して起動できない


Swagger-uiを起動して、http://localhost:9091/realecantina/rest/api-docs/myCamel/swagger.jsonを入力して、Explorerを押下
