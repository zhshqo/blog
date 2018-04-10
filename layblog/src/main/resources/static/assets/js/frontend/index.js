layui.use(['laytpl', 'element', 'flow'],function () {
	
	var flow = layui.flow;
    var element = layui.element;
    var laytpl = layui.laytpl;

    flow.load({
        elem: '#article-list' //流加载容器
        , done: function (page, next) { //执行下一页的回调
        	return nextPage(page, next, laytpl);
        }
    });
	
});

var ani =
    '{{# layui.each(d.page.result, function(index, item){ }}' +
    '<div class="layui-collapse layui-panel layui-article animated fadeInUp">' +
    '   <div class="layui-colla-item">' +
    '       <div class="layui-colla-content layui-show layui-article">' +
    '           <fieldset class="layui-elem-field layui-field-title">' +
    '               <legend class="center-to-head">' +
    '                   <span class="layui-badge layui-bg-green"> {{ item.cateName }}</span>' +
    '                   {{# if(item.top){ }}' +
    '                   <span class="layui-badge layui-bg-cyan"> 置顶</span>' +
    '                   {{# } }}' +
    '                   <a href="/article/{{ item.id }}">{{ item.title }}</a>' +
    '               </legend>' +
    '               {{# if(item.cover === null || item.cover === ""){ }}' +
    '               <div class="layui-field-box">' +
    '                   &nbsp;&nbsp;&nbsp;&nbsp;{{ item.summary }}...&nbsp;<a class="loading" href="/article/{{ item.id }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '               </div>' +
    '               {{# } }}' +
    '               {{# if(item.cover !== null && item.cover !== ""){ }}' +
    '               <div class="layui-field-box has-pic">' +
    '                   <div class="layui-row layui-col-space10">' +
    '                       <div class="layui-col-lg10 layui-col-md10 layui-col-sm10 layui-col-xs12">' +
    '                           &nbsp;&nbsp;&nbsp;&nbsp;{{ item.summary }}...&nbsp;<a class="loading" href="/article/{{ item.id }}">更多<i class="fa fa-angle-double-right"></i> </a>' +
    '                       </div>' +
    '                       <div class="layui-col-lg2 layui-col-md2 layui-col-sm2">' +
    '                           <img src="{{ item.cover }}" class="panel-pic">' +
    '                       </div>' +
    '                   </div>' +
    '               </div>' +
    '               {{# } }}' +
    '               <div class="operation">' +
    '                   <div class="tags">' +
    '                       {{# layui.each(d.tags[item.id], function(index1, item1){ }}' +
    '                       <span class="layui-badge-rim" onclick="searchTag(this)"><i class="fa fa-tag"></i> {{ item1.name }}</span>' +
    '                       {{# }); }}' +
    '                   </div>' +
    '                   <div class="info">' +
    '                       <span class="views"><i class="fa fa-thermometer-half"></i> {{ item.viewsCnt }}<code style="font-family: cursive;">℃</code></span>' +
    '                       <span class="datetime"><i class="fa fa-bullhorn"></i> {{ BMY.dateFormatter(item.postTime,"/", false) }}</span>' +
    '                   </div>' +
    '               </div>' +
    '           </fieldset>' +
    '       </div>' +
    '   </div> ' +
    '</div>' +
    '{{# });  }}';

function nextPage(page, next, tpl) {
    $.post("/next", {
        limit: 10,
        page: page
    }, function (json) {
        if (json.code === BMY.status.ok) {
            tpl(ani).render(json.data, function (html) {
                next(html, json.data.page.hasNext)
            });
            if (BMY.affix !== undefined && BMY.affix !== null) {
                BMY.affix.reinit();
            }
            $(window).resize();
        }

    });
}

function searchTag(span) {
    var s = $(span).text();
    s = s.substring(1);
    location.href = "/index?s=" + s + "&t=" + s
}