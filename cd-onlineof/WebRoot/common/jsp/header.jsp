<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<body>
		<div style="border: 1px solid #A9A9A9; width: 95%; height: 50px;">
			<table style="width: 100%; height: 100%;">
				<tr>
					<td style="width: 50px;">
						<img src="" />
					</td>
					<td>
						<a href="welcomContent.jsp" target="contentFrame"><b>首页</b>
						</a>
					</td>
					<td>
						<a href="loadAllRestaurant.do" target="contentFrame"><b>在线订餐</b>
						</a>
					</td>
					<td>
						<a href="recommendedFeeding.jsp" target="contentFrame"><b>觅食推荐</b>
						</a>
					</td>
					<td>
						<a href="bookRestaurant.jsp" target="contentFrame"><b>餐厅大全</b>
						</a>
					</td>
					<td>
						<a href="foodSearch.jsp" target="contentFrame"><b>美食搜索</b>
						</a>
					</td>
					<td>
						<a href="healthyEating.jsp" target="contentFrame"><b>健康饮食</b>
						</a>
					</td>
					<td>
						<a href="tableManners.jsp" target="contentFrame"><b>饮食礼仪</b>
						</a>
					</td>
					<td>
						<a href="foodTaboos.jsp" target="contentFrame"><b>饮食禁忌</b>
						</a>
					</td>
					<td>
						<a href="userRegister.jsp" target="contentFrame"><b>用户注册</b>
						</a>
					</td>
					<td>
						<a href="soundOnline.jsp" target="contentFrame"><b>在线留声</b>
						</a>
					</td>
				</tr>
			</table>
		</div>
		<div style="border: 1px solid #FFFFFF; width: 95%; height: 98px;">
			<table style="width: 100%; height: 100%;">
				<tr>
					<td style="width: 80%; background-image: url('image/header1.jpg')"></td>
					<td style="width: 20%; border: 5px solid #E6E6FA;">
						<table
							style="width: 100%; height: 100%; font-size: 10pt; border: 5px solid #F8F8FF;">
							<tr>
								<td colspan="2">
									<form action="login.do?method=doLogin" method="post">
										<table style="width: 100%; height: 100%; font-size: 10pt;">
											<tr>
												<td align="right">
													用户名:
												</td>
												<td>
													<input type="text" name="loginName" size="11.5" />
												</td>
											</tr>
											<tr>
												<td align="right">
													密&nbsp;&nbsp;&nbsp;&nbsp;码:
												</td>
												<td>
													<input type="password" name="password" size="12" />
												</td>
											</tr>
										</table>
									</form>
								</td>
								<td align="left;">
									<img src="common/images/login.jpg"></img>
								</td>
							</tr>
							<tr>
								<td align="center">
									<a href="#">新用户注册</a>
								</td>
								<td align="center">
									<a href="#">忘记密码</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div style="border: 1px solid #A9A9A9; width: 95%; height: 30px;">
			<table
				style="width: 100%; height: 100%; font-size: 10pt; background-color: #FDF5E6;">
				<tr>
					<td style="width: 60%;">
						<span style="white-space: nowrap;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2009年7月3日</span>
					</td>
					<td style="width: 20%;">
						<span style="white-space: nowrap;"> <select>
								<option>
									餐厅分类
								</option>
								<option>
									餐厅分类
								</option>
								<option>
									餐厅分类
								</option>
								<option>
									餐厅分类
								</option>
								<option>
									餐厅分类
								</option>
								<option>
									餐厅分类
								</option>
							</select> <input type="text" value="请输入餐厅名称" size="20" /> <input
								type="button" value="搜索"
								style="border: 1px solid #A9A9A9; background-color: #FFFFFF; width: 50px;" />
						</span>
					</td>
					<td style="width: 20%;">
						<marquee style="boder: 1px solid #A9A9A9; width: 160px;">
							紫航海鲜酒店 除酒水、烟、珍品 95折
						</marquee>
					</td>
				</tr>
			</table>
		</div>
		<div style="border: 1px solid #A9A9A9; width: 95%; height: 100px;">
			广告
		</div>
	</body>
</html>
