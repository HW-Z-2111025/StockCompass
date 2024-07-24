		$(document).ready(function() {
		    $('.ff .news ul li a').on('click', function(e) {
		        e.preventDefault();
		        var targetId = $(this).data('target');
				// 直接切换显示目标内容，无需特别处理'active'类，除非它有其他样式影响
				$('.ff .bd .zixun').hide(); // 隐藏所有内容区域
				$('#' + targetId).show(); // 显示点击对应的内容区域
				
		    });
		});
		
		
		$(document).ready(function() {
		    $('.ff .discuss ul li a').on('click', function(e) {
		        e.preventDefault();
		        var targetId = $(this).data('target');
				// 直接切换显示目标内容，无需特别处理'active'类，除非它有其他样式影响
				$('.ff .bd .ds').hide(); // 隐藏所有内容区域
				$('#' + targetId).show(); // 显示点击对应的内容区域
		    });
		});
		
		
window.onload = function(){
  var box=this.document.getElementsByClassName("re")[0];
  var lik=box.getElementsByTagName("li");
  var lik2=this.document.getElementsByClassName("tip");
  function fun(i,j){//转换图片函数，就是把透明度改了一下
    lik[i].style.opacity=1;
    lik[j].style.opacity=0;
    // lik2[i].style.backgroundColor="#ffffff";//改一下小图标
    // lik2[j].style.backgroundColor="#00000000"
  }
  fun(0,1);//初始化下
  var i =0;
  function auto(){//轮播循环函数
    if(++i>=4){
      i=0;
      fun(0,3);
    }
    else fun(i,i-1);
  }
  timer=this.setInterval(auto,2000);
  box.onmouseover = function () { //鼠标划上去，停止轮播
    // console.log('good');
    clearInterval(timer);
  }
  box.onmouseout = function () { //鼠标划出，继续轮播
    timer = setInterval(auto, 2000); //调用定时器
  }

}
