<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>����� ����</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
	<div class="container">
		<h2 class="text-center">����� ���</h2>
		<table class="table table-bordered table table-hover"> 
			<thead> 
				<tr> 
					<th>�̸�</th> 
					<th>�̸���</th> 
					<th>����</th>
					<th>�������</th>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</tr> 
		</thead> 
		<tbody> 
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td>
					 	<a href="getCustomer.do?cname=${customer.cname}">${customer.cname}</a>
					 </td>
					<td>${customer.cname}</td>
					<td>${customer.cemail}</td>
					<td>${customer.cage}</td>
					<td>${customer.centrydate}</td>
					<td>
					     <a href="updateUserForm.do?cname=${customer.cname}">����</a>
					</td>
					<td><a href="#" onclick="deleteUser('${customer.cname}')">����</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<a href="insertUserForm.do">����� ���</a>
				</td>
			</tr>
		</tbody> 
	</table>
	</div>
</body>
</html>

































