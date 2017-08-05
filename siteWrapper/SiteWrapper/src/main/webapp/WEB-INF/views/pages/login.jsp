<div>
<form:form action="/SiteWrapper/login" modelAttribute="loginForm" method="post" class="form-signin">
  	<h2 class="form-signin-heading">ログイン</h2>
  		<br/><br/>
  		<c:out value="${message}" />
  		<table class="table">
  			<thead>
  				<tr>
  					<td class="col-xs-1"></td>
  					<td class="col-xs-4"></td>
  					<td class="col-xs-7"></td>
  				</tr>
  			</thead>
  			<tbody>
  				<tr>
    					<td><label for="userId" class="control-label">ユーザーID</label></td>
      					<td><form:input type="text" class="form-control" id="idUserId" path="userId" /></td>
      					<td><form:errors path="userId" element="div" cssStyle="color:red" /></td>
      			</tr>
				<tr>
      					<td><label for="password" class="control-label">パスワード</label></td>
      					<td><form:input type="password" class="form-control" id="idPassword" path="password" /></td>
      					<td><form:errors path="password" element="div" cssStyle="color:red" /></td>
      			</tr>
      			<tr>
      				<td colspan="2" class="login_remenber">
    						<!-- <label><input type="checkbox"> Remember me</label> -->
    						<form:checkbox path="checked" label="ログイン状態を保持する" />
 					</td>
      			</tr>
      			<tr>
      				<td colspan="2" class="login_execute_button">
				      		<input type="submit" class="btn btn-success" value="login" name="execute" />
			      	</td>
		      	</tr>
      		</tbody>
      	</table>
</form:form>
</div>