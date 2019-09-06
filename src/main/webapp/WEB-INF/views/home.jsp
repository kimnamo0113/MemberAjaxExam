<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	label{
		width:100px;
		float: left;
	}
	table{
		border: 1px solid black;
	}
	th,td{
		border:1px solid black;
	}
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.2.0/handlebars.min.js"></script>
 

</head>
<body>
	<label>아이디</label><input type="text" name="userid"><br>
	<label>이름</label><input type="text" name="username"><br>
	<label>비밀번호</label><input type="text" name="userpw"><br>
	<label>이메일</label><input type="text" name="email"><br>
	<button id="btnAdd">추가</button>
	<button id="btnList">리스트 가져오기</button>
<br>
<table id="membertable">
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>이메일</th>
		<th></th>
	</tr>
	
	
	
</table>


	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
			<div class='modal-dialog'>
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title"></h4><!-- rno번호 넣음 -->
					</div>
					<div class="modal-body" data-rno=""><!-- rno번호 넣음 -->
						<p><input type="text" id="replytext" class="form-control"></p><!-- input에 text넣음 -->
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-info" id="btnReplySaveMod">Modify</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>						
					</div>
				</div>
			</div>
		</div>
		
		<script id="template" type="text/x-handlebars-template">
		{{#each.}}
		<tr class="item">
			<td>{{userid}}</td>
			<td>{{username}}</td>
			<td>{{userpw}}</td>
			<td>{{email}}</td>
			<td>
				<a class="btn btn-primary btn-xs btnReplyModify" class="update" data-toggle="modal" data-target="#modifyModal">수정</a>
				<a class="delete">삭제</a>
			</td>
		</tr>
		{{/each}}
</script>
<script>
	

	function getListAll(){
		
		$.ajax({
			url:"test",
			type:"get",
			dataType:"json",
			
			success:function(res){
				console.log(res);
				
				$(".item").remove();
				
				var source = $("#template").html();
				var func = Handlebars.compile(source);
				var str = func(res);
				$("#membertable").append(str);
			}
		})
	}
	$("#btnList").click(function() {
		getListAll();
	})
	
	$("#btnAdd").click(function() {
		var userid=$("input[name='userid']").val();
		var username=$("input[name='username']").val();
		var userpw=$("input[name='userpw']").val();
		var email=$("input[name='email']").val();
		
		
		alert(userid);
		//@RequestBody
		//var str = "{bno:bno,replyer:replyer,replytext:replytext}";
		var json = {userid:userid,username:username,userpw:userpw,email:email};
		var data = JSON.stringify(json)
		
		$.ajax({
			url:"test",
			type:"post",
			headers:{
				"Content-Type":"application/json"
			},
			//get방식일때 쓴거
			data:data,
			dataType:"text",
			success:function(res){
				console.log(res);
			}
			
		})
		
	})
	
</script>

</body>
</html>