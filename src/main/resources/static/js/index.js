// JavaScript Document
 
//左侧下菜单
$(document).ready(function(e) {
 
  $(".leftnav li").children("div").hide();
  $(".leftnav li a").toggle(function(){
		$(this).siblings("div").slideDown()  
  },function(){
	   $(this).siblings("div").slideUp()
  }) 
});

//上传头像(基本信息)
function handleFiles(obj,id) {
    var file = document.getElementById("icon");
	
    var files = obj.files;
    img = new Image();
    if(window.URL){
        //File API
        img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
        img.onload = function(e) {
        window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
        }
    }
    file.src=img.src;
    //上传文件
        var fd = new FormData(),//实例化一个表单
        xhr = new XMLHttpRequest();
        fd.append('headimg', files[0]);//追加图片元素
        xhr.open('post', 'user.php?act=act_edit_img');//请求方式，请求地址
        xhr.send(fd);
}
//上传头像(基本信息)
function handleFiles2(obj,id) {
    var file2 = document.getElementById("icon2");
	
    var files = obj.files;
    img = new Image();
    if(window.URL){
        //File API
        img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
        img.onload = function(e) {
        window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
        }
    }
    file2.src=img.src;
    //上传文件
        var fd = new FormData(),//实例化一个表单
        xhr = new XMLHttpRequest();
        fd.append('headimg', files2[0]);//追加图片元素
        xhr.open('post', 'user.php?act=act_edit_img');//请求方式，请求地址
        xhr.send(fd);
}
////上传头像(基本信息)
function handleFiles3(obj,id) {
    var file3 = document.getElementById("icon3");
	
    var files = obj.files;
    img = new Image();
    if(window.URL){
        //File API
        img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
        img.onload = function(e) {
        window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
        }
    }
    file3.src=img.src;
    //上传文件
        var fd = new FormData(),//实例化一个表单
        xhr = new XMLHttpRequest();
        fd.append('headimg', files3[0]);//追加图片元素
        xhr.open('post', 'user.php?act=act_edit_img');//请求方式，请求地址
        xhr.send(fd);
}

//弹窗
$(document).ready(function($) {
	//01
	$('.bianji-btn,.cc').click(function(){
		$('.pop-mask').fadeIn(100);
		$('.pop').slideDown(200);
	})
	$('.pop .close,.baocun').click(function(){
		$('.pop-mask').fadeOut(100);
		$('.pop').slideUp(200);
	})
	//02
	$('.bianji-btn2,.bb').click(function(){
		$('.pop-mask').fadeIn(100);
		$('.pop2').slideDown(200);
	})
	$('.pop2 .close,.baocun').click(function(){
		$('.pop-mask').fadeOut(100);
		$('.pop2').slideUp(200);
	})
    $('.pop22 .close,.baocun').click(function(){
        $('.pop-mask').fadeOut(100);
        $('.pop22').slideUp(200);
    })
	//03
	$('.xinzeng,.zuo2 .a1').click(function(){
		
		$('.pop-mask').fadeIn(100);
		$('.pop2').slideDown(200);
	})

	$('.pop2 .close,.baocun').click(function(){
        $('.pop-mask').fadeOut(100);
        $('.pop2').slideUp(200);
    })
    $('.pop22 .close,.baocun').click(function(){
        $('.pop-mask').fadeOut(100);
        $('.pop22').slideUp(200);
    })
	//04
	$('#teboxjia').click(function(){
		$('.pop-mask').fadeIn(100);
		$('#tan').slideDown(200);
	})
	$('#tan .close,.baocun').click(function(){
		$('.pop-mask').fadeOut(100);
		$('#tan').slideUp(200);
	})
	//05
	$('.dd,.pp').click(function(){
		$('.pop-mask').fadeIn(100);
		$('.pop3').slideDown(200);
	})
	$('.pop3 .close,.baocun').click(function(){
		$('.pop-mask').fadeOut(100);
		$('.pop3').slideUp(200);
	})
	
})
//绑定效果;
$(document).ready(function(e) {
		
    $(".databox #b1").click(function(){
		var text=$(this).text();
		if(text=="解除绑定"){
			 var msg="确定要解除绑定吗"
			 if(confirm(msg)==true){
				 $(this).text("+绑定");
				 $(this).siblings().find("span").hide();
				 return true	 
			}else{
				return false	
			}
			 
		}else if(text=="+绑定"){
			$('.pop-mask').fadeIn(100);
			$('.pop4').slideDown(200);	
			$('.pop4 .close,.baocun').click(function(){
			$('.pop-mask').fadeOut(100);
			$('.pop4').slideUp(200);
		})
		}
		
	})
	$(".databox #b2").click(function(){
		var text=$(this).text();
		if(text=="解除绑定"){
			 var msg="确定要解除绑定吗"
			 if(confirm(msg)==true){
				 $(this).text("+绑定");
				 $(this).siblings().find("span").hide();
				 return true	 
			}else{
				return false	
			}
			 
		}else if(text=="+绑定"){
			$('.pop-mask').fadeIn(100);
			$('.pop4').slideDown(200);	
			$('.pop4 .close,.baocun').click(function(){
			$('.pop-mask').fadeOut(100);
			$('.pop4').slideUp(200);
		})
		}
		
	})
	$(".databox #b3").click(function(){
		var text=$(this).text();
		if(text=="解除绑定"){
			 var msg="确定要解除绑定吗"
			 if(confirm(msg)==true){
				 $(this).text("+绑定");
				 $(this).siblings().find("span").hide();
				 return true	 
			}else{
				return false	
			}
			 
		}else if(text=="+绑定"){
			$('.pop-mask').fadeIn(100);
			$('.pop3').slideDown(200);	
			$('.pop3 .close,.baocun').click(function(){
			$('.pop-mask').fadeOut(100);
			$('.pop3').slideUp(200);
		})
		}
		
	})
});

$(document).ready(function(e) {
	
	
	
	
	
	//店铺菜单切换
    $(".shopbox").children("div").hide().eq(0).show();
	$(".tab li").click(function(){
		var index=$(this).index();
		$("#qie").children("div").hide().eq(index).show();
		
		$(".tab li").eq(index).addClass("current").siblings().removeClass("current")	
	})
	
	//上传封面
	
function handleFiles(obj,id) {
    var file = document.getElementById("icon");
    var files = obj.files;
    img = new Image();
    if(window.URL){
        //File API
        img.src = window.URL.createObjectURL(files[0]); //创建一个object URL，并不是你的本地路径
        img.onload = function(e) {
        window.URL.revokeObjectURL(this.src); //图片加载后，释放object URL
        }
    }
    file.src=img.src;
    //上传文件
        var fd = new FormData(),//实例化一个表单
        xhr = new XMLHttpRequest();
        fd.append('headimg', files[0]);//追加图片元素
        xhr.open('post', 'user.php?act=act_edit_img');//请求方式，请求地址
        xhr.send(fd);
}
	
	//类目属性样式切换
	$(".shop2 ul li").click(function(){
		$(this).addClass("current").siblings().removeClass("current")	
	})
	
	
	
	//评价
			window.onload = function(){
		
		var star = document.getElementById("star");
		
		var star_li = document.getElementById("star").getElementsByTagName("a");
		
		var star_word = document.getElementById("star_word");
		
		var result = document.getElementById("result");
		
		var i=0;
		
		var j=0;
		
		var len = star_li.length;
		
		var word = ['不满意','一般',"满意","非常满意","惊喜"]
		
		for(i=0; i<len; i++){
		
		star_li[i].index = i;
		//鼠标进入
		star_li[i].onmouseover = function(){
		
			star_word.style.display = "block";
			
			star_word.innerHTML = word[this.index];
		
			for(i=0; i<=this.index; i++){
			
			star_li[i].className = "act";
			
				}
		 }
		//鼠标离开
		
		 star_li[i].onmouseout = function(){
			
				for(i=0; i<len; i++){
				
				star_li[i].className = "";
				
					}
		}
		//鼠标点击
		star_li[i].onclick = function(){
			alert()
			star_word.style.display = "block";
			
			star_word.innerHTML = word[this.index];
		
			for(i=0; i<=this.index; i++){
			
			star_li[i].className = "act";
			
				}
		 }
		
}
		
}
		

		
		
		
	
	
	
	
	
	
});



