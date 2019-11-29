/**by zxm null*/
/**
 * 统一处理js方法
 */
/**框架*/
var message;
layui.config({
  base: '/plugin/build/js/',
  version: '1.0.1'
}).extend({
    tablePlug: 'tablePlug/tablePlug' //主入口模块
}).use(['app', 'message','tablePlug'], function() {
  var app = layui.app,
      $ = layui.jquery,
      tablePlug = layui.tablePlug,
      layer = layui.layer;
  //将message设置为全局以便子页面调用
  message = layui.message;
  //主入口
  app.set({
    type: 'iframe'
  }).init();
  $('dl.skin > dd').on('click', function() {
    var $that = $(this);
    var skin = $that.children('a').data('skin');
    switchSkin(skin);
  });
  var setSkin = function(value) {
        layui.data('kit_skin', {
          key: 'skin',
          value: value
        });
      },
      getSkinName = function() {
        return layui.data('kit_skin').skin;
      },
      switchSkin = function(value) {
        var _target = $('link[kit-skin]')[0];
        _target.href = _target.href.substring(0, _target.href.lastIndexOf('/') + 1) + value + _target.href.substring(_target.href.lastIndexOf('.'));
        setSkin(value);
      },
      initSkin = function() {
        var skin = getSkinName();
        switchSkin(skin === undefined ? 'default' : skin);
      }();
});