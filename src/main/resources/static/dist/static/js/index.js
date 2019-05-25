let boxs=new Array();
let  n=0;
function getJsonLength(json){
  n=0;
  for (var i in json) {
    n++;
  }

}
console.log("啦啦啦啦1");
$(function () {

    addEvent();
    setPosition();
  console.log("执行了");
  }
);
function abc () {
  let url="http://localhost:8080/orange/index"
  $.ajax({
    type: "get",
    url: url,
//      data: "para="+para,  此处data可以为 a=1&b=2类型的字符串 或 json数据。
    data: "",
    cache: false,
    async : true,
    dataType: "JSON",
    success: function (data ,textStatus, jqXHR)
    {
      console.log(data.status);
      console.log(data.data);
      if(data.status=="1"){
        n=0;
        let  aphoto; let  name; let title;let content; let user_photo;
        boxs=data.data;
        getJsonLength(boxs);
        console.log(n);
        var str;
        for(i=0;i<n;i++){
          $("#main").append("<div class=\"pin\">\n" +
            "        <div class=\"box\">\n" +
            "            <img src=\""+boxs[i].aphoto+"\">\n" +
            "            <div class=\"userinfo\">\n" +
            "                <img src=\""+boxs[i].user_photo+"\">\n" +
            "                <span>"+ boxs[i].name+"</span>\n" +
            "            </div>\n" +
            "            <div class=\"love\">\n" +
            "            <img src=\"images/love.png\"></div>\n" +
            "            <article>"+boxs[i].content+"</article>\n" +
            "        </div>\n" +
            "    </div>");
        }
        setPosition();

      }

    },
    error:function (XMLHttpRequest, textStatus, errorThrown) {
      alert("请求失败！");
    }
  });
}
function addEvent(){
  console.log("啦啦啦啦2");
  let navOffset=50;
  $(window).scroll(function(){
    var scrollPos=$(window).scrollTop();
    if(scrollPos >=navOffset){
      $("#header").addClass("fixed");
      $("#header").css({"background-color":"rgba(242,242,242,0.6)"});
    }else{
      $("#header").removeClass("fixed");
      $("#header").css({"background-color":"transparent"});
    }
  });
  $(".menu").mouseover(function(){
    $(this).css("border-color","rgba(128lll,128,128,1)");
    $(this).css("color","rgba(128,128,128,1)");
  });
  $(".menu").mouseout(function(){
    $(this).css("border-color","white");
    $(this).css("color","white");
  });

}




function  setPosition(){
  //获取父级对象
  let oParent = document.getElementById("boxes");
  //获取父级[第一个参数]下的所有的子元素[按照第二个参数匹配]
  let aPin = getClassObject(oParent,"pin");
  //获取每一个块的宽度
  let iPinW = aPin[0].offsetWidth;
  // //计算每行放多少个pin(瀑布流块)页面的宽度/每一个瀑布流块的宽度
  let num = Math.floor(document.documentElement.clientWidth/iPinW);

  let compareArray = [];
  //遍历获取到的所有瀑布流块
  for (let i = 0; i<aPin.length; i++) {
    Console.log("i",i);
    if(i<num){
      //成行元素
      compareArray[i] = aPin[i].offsetHeight;
    }else{
      //获取成行元素中高度最低的值
      let minHeight = Math.min.apply('',compareArray);
      //alert(compareArray + ",min=" + minHeight);
      //获取成行元素中高度最低元素的索引
      let minHkey = getMinHeightKey(compareArray,minHeight);
      //为新增的瀑布流块设置定位
      aPin[i].style.position = "absolute";
      aPin[i].style.top = minHeight + "px";
      //设定新增加的瀑布流块的top和left
      aPin[i].style.left =aPin[minHkey].offsetLeft + "px";
      //将该索引位置的高度改变为新增后的高度[原来瀑布流块的高度+新增的瀑布流块的高度]
      compareArray[minHkey] += aPin[i].offsetHeight;
    }

  }

}
/**
 *     获取parent下所有样式名为className的对象集合
 */
function getClassObject(parent,className){
  let obj = parent.getElementsByTagName("*");
  let result = [];
  for(let i=0; i<obj.length;i++){
    //变量如果匹配className,将匹配的对象放入数组
    if(obj[i].className===className){
      result.push(obj[i]);
    }
  }
  return result;
}

/**
 *    获取arr数组中值为minH的值在数组中的索引
 */
function getMinHeightKey(arr,minH){
  for(key in arr){
    if(arr[key] == minH){
      return key;
    }
  }
}
