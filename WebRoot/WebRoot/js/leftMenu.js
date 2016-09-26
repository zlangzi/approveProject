/**
 * 外循环：查找所有的没有parent_id的元素根元素
 * 根据没有根元素递归其所有子元素
 * leftMenu data from database
 * 
 * 
					<li id="" class="dropdown">
					<a href="#"	class="dropdown-toggle user-a" data-toggle="dropdown">登陆|注册</a>
						<ul class="dropdown-menu user-ul" style="min-width: 97px">
							<li><a href="#" class="rotateInDownRight dialog">注册</a></li>
							<li><a href="#" class="rotateInDownRight login-dialog">登录</a></li>
						</ul>
					</li>
 */
var data=[{"id":1,"name":"菜单1","url":"#","parentId":"0","isvisiable":1},{"id":2,"name":"菜单2","url":"#","parentId":"0","isvisiable":1},{"id":3,"name":"菜单3","url":"#","parentId":"0","isvisiable":1},{"id":4,"name":"菜单4","url":"#","parentId":"0","isvisiable":1},{"id":5,"name":"菜单5","url":"#","parentId":"0","isvisiable":1},{"id":6,"name":"子菜单1","url":"aaa","parentId":"5","isvisiable":1},{"id":7,"name":"子菜单2","url":"aa","parentId":"5","isvisiable":1}];
function loadMenu(menu){
	var  sub="";
	console.log(menu);
	//url=='#',说明是父元素，不具有URL
	if(menu.url=='#'){
		sub="<li id='id_"+menu.id+"' class='dropdown'><a href='#'	class='dropdown-toggle user-a' menu-toggle='dropdown'>"+menu.name+"</a><ul class='dropdown-menu user-ul' style='min-width: 97px'></ul></li>"
		$('#id_'+menu.parentId).append(sub);
	}
	else{
		alert("ein");
		sub="<li><a href='"+menu.url+"' class='rotateInDownRight'>"+menu.name+"</a></li>"
		$('#id_'+menu.parentId +' > ul').append(sub);
	}
	
	
}

$(function(){
	
	//第一层：parent_id=''，
	//第二层之后的parent_id都存在
	var menu=$('#leftMenu');
	menu.append("<ul id=id_0 class='nav nav-pills nav-stacked'></ul>");
	for(var i=0;i<data.length;i++){
		loadMenu(data[i]);
	//递归加载
	}
	
	
	
	
});
