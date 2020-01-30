<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel = "stylesheet" href = "./css/style.css">
	<link rel = "stylesheet" href = "./css/table.css">
	<link rel = "stylesheet" href = "./css/notFormTable.css">
	<title>商品購入履歴</title>
	</head>
	<body>
			<!-- ヘッダーを表示 -->
		<jsp:include page = "header.jsp"/>
			<!-- 商品購入履歴を表示 -->
		<div id = "main">
		<h1>商品購入履歴画面</h1>
		<s:if test = "purchaseHistoryInfoDTOList != null && purchaseHistoryInfoDTOList.size()>0">
		<table class = "not_form_table_list">
		<thead>
		<tr>
			<th><s:label value = "商品名"/></th>
			<th><s:label value = "ふりがな"/></th>
			<th><s:label value = "商品画像"/></th>
			<th><s:label value = "発売会社名"/></th>
			<th><s:label value = "発売年月日"/></th>
			<th><s:label value = "値段"/></th>
			<th><s:label value = "個数"/></th>
			<th><s:label value = "合計金額"/></th>
			<th><s:label value = "宛先名前"/></th>
			<th><s:label value = "宛先住所"/></th>
		</tr>

		<tbody>
			<!-- データベースから購入情報を格納 -->
		<s:iterator value = "purchaseHistoryInfoDTOList">
		<tr>
				<td><s:property value = "productName"/></td>
				<td><s:property value = "productNameKana"/></td>
				<td><img src ='<s:property value = "imageFilePath"/>' width = "50px" height = "50px"/></td>
				<td><s:property value = "releaseCompany"/></td>
				<td><s:property value = "releaseDate"/></td>
				<td><s:property value = "price"/>円</td>
				<td><s:property value = "productCount"/>個</td>
				<td><s:property value = "subtotal"/>円</td>
				<td><s:property value = "familyName"/><span> </span><s:property value ="firstName"/></td>
				<td><s:property value = "userAddress"/></td>
		</tr>
		</s:iterator>
		</tbody>
		</table>
			<!--  商品履歴削除ボタン -->
		<div class = "submit_btn_box">
		<s:form action = "DeletePurchaseHistoryAction">
			<s:submit value = "履歴削除" class = "submit_btn"/>
		</s:form>
		</div>
		</s:if>
          <!-- 商品購入履歴情報がない場合 -->
		<s:else>
		<div class = "info">
		商品購入履歴情報がありません。
		</div>
		</s:else>
		</div>
	</body>
</html>