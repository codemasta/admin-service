!function(e,a,i,t){var s="1.0",n=function(a,i){this.elem=a,this.$elem=e(a),this.options=i,this.data=this._sanitizeData(this.$elem.data()),this.init()};n.prototype={defaults:{autoSelector:".ason-widget",type:t,target:t,find:t,parent:!0,content:!1,delay:0,duration:400,animation:null,animationOpen:"slideDown",animationClose:"slideUp",fullscreenClass:"fullscreen",fullscreenOpenClass:"fullscreen-open",loaderClass:"spinner audiowave",toggleClass:"toggle-closed",scrollbarClass:"ps-wrapper",iconToggleOpen:"fa fa-chevron-down",iconToggleClose:"fa fa-chevron-up",iconExpand:"fa fa-expand",iconContract:"fa fa-compress",iconDelete:"fa fa-times",iconRefresh:"fa fa-refresh",iconSpin:"fa-spin",minHeight:null,maxHeight:null,height:null,items:".ui-drag-item",connectWith:".ui-drag-container",handle:".ui-drag-handle",cancel:".ui-drag-disabled",placeholder:"ui-drag-placeholder",opacity:.8,revert:!0,baseHeader:"l-header-slide",header:"l-header-slide-1",headerPush:"l-header-slide-push-1",headerOpen:"l-header-slide-open",baseFooter:"l-footer-slide",footer:"l-footer-slide-1",footerPush:"l-footer-slide-push-1",footerOpen:"l-footer-slide-open",baseSidebar:"l-sidebar",sidebar:"l-sidebar-1",sidebarHidden:"l-sidebar-hidden",sidebarCompactLeft:"l-sidebar-compact-left",sidebarCompactRight:"l-sidebar-compact-right",sidebarCollapsedLeft:"l-sidebar-collapsed-left",sidebarCollapsedRight:"l-sidebar-collapsed-right",baseSlidebar:"l-slidebar",slidebarLeft:"l-slidebar-left-1",slidebarRight:"l-slidebar-right-1",slidebarLeftPush:"l-slidebar-left-push-1",slidebarRightPush:"l-slidebar-right-push-1",slidebarStatic:"l-slidebar-static",slidebarLeftOpen:"l-slidebar-left-open",slidebarRightOpen:"l-slidebar-right-open",isSlide:t,isPush:!1,isStatic:!1,isRight:!1,sizeXl:1408,sizeLg:1200,sizeMd:992,sizeSm:768,onAll:null,onFull:"sidebar",onXl:"sidebar",onLg:"sidebar",onMd:"compact",onSm:"collapsed",toAll:null,toFull:"compact",toXl:"compact",toLg:"compact",toMd:"collapsed",toSm:"hidden",animResize:null,animAll:null,animFull:null,animXl:null,animLg:null,animMd:null,animSm:null,collapsed:!0,closeSameLevel:!0,isNavHidden:!0,isRootHidden:!0,navScrollBar:!0,navHover:!0,navScroll:!0,navScrollDelay:0,navScrollDuration:400,navScrollOffset:-150,navTheme:"ason-nav",navSkin:null,navUlOpen:"ul-open",navUlClosed:"ul-closed",navUlBack:"ul-back",navLi:"node",navLiRoot:"root",navLiOpen:"open",navLiClosed:"closed",animInit:"transition.slideDownIn",animInitStagger:100,animInitDrag:!0,animOpen:"transition.slideDownIn",animOpenStagger:50,animOpenDrag:!0,animEasing:"easeOutQuart"},init:function(){var a=this;switch(a.log=e.fn.asonwidget.log,a.config=e.extend({},a.defaults,a.options,a.data),e.each(a.config,function(e,i){"function"==typeof i&&a.$elem.on(e+".ason",function(){i(a.$elem)})}),a.config.type){case"fullscreen":this._fullscreen();break;case"delete":this._delete();break;case"refresh":this._refresh();break;case"toggle":this._toggle();break;case"scrollbar":this._scrollbar();break;case"draggable":this._draggable();break;case"header":this._header_footer(!0);break;case"footer":this._header_footer(!1);break;case"sidebar":this._sidebar();break;case"menu":this._menu();break;default:a.log("Type is not defined or it's not valid")}return this},_fullscreen:function(){var a=this,i=a.config,t=a.$elem,s=e.fn.asonwidget.expandMarkup(i),n=e.fn.asonwidget.contractMarkup(i);i.content&&a.$elem.html(s),t.on("click",function(l){if(l.preventDefault(),"undefined"==typeof i.target)return void a.log("ERROR: Please define a target attribute for - FULLSCREEN - widget!");if(t.trigger("beforeInit.ason"),i.find)var r=t.parents(i.find),o=r.find(i.target);else var o=i.parent?t.parents(i.target):e(i.target);o.hasClass(i.fullscreenClass)?(i.content&&t.html(s),e("body").removeClass(i.fullscreenOpenClass),o.removeClass(i.fullscreenClass)):(i.content&&t.html(n),e("body").addClass(i.fullscreenOpenClass),o.addClass(i.fullscreenClass)),t.trigger("afterInit.ason")})},_delete:function(){var a=this,i=a.config,t=a.$elem,s=e.fn.asonwidget.deleteMarkup(i);i.content&&a.$elem.html(s),t.on("click",function(s){if(s.preventDefault(),"undefined"==typeof i.target)return void a.log("ERROR: Please define a target attribute for - DELETE - widget!!");if(t.trigger("beforeInit.ason"),i.find)var n=t.parents(i.find),l=n.find(i.target);else var l=i.parent?t.parents(i.target):e(i.target);if(e("body").removeClass(i.fullscreenOpenClass),e.Velocity){if(null!=i.animation&&"slideUp"!=i.animation&&"fadeOut"!=i.animation)return void a.log("Animation is not defined or it's not valid");var r=i.animation?i.animation:{display:"none",opacity:0},o=i.animation?i.duration:0;l.velocity(r,{delay:i.delay,duration:o,begin:function(e){t.trigger("begin.ason")},complete:function(e){t.trigger("complete.ason"),l.remove()}})}else switch(i.animation){case null:l.remove();break;case"slideUp":l.slideUp(i.duration,function(){t.trigger("complete.ason"),l.remove()});break;case"fadeOut":l.fadeOut(i.duration,function(){t.trigger("complete.ason"),l.remove()});break;default:a.log("Animation is not defined or it's not valid")}t.trigger("afterInit.ason")})},_refresh:function(){var a=this,i=a.config,t=a.$elem,s=e.fn.asonwidget.refreshMarkup(i.iconRefresh),n=e.fn.asonwidget.refreshMarkup(i.iconRefresh+" "+i.iconSpin);i.content&&a.$elem.html(s),t.on("click",function(l){if(l.preventDefault(),"undefined"==typeof i.target)return void a.log("ERROR: Please define a target attribute for - REFRESH - widget!");if(t.trigger("beforeInit.ason"),i.find)var r=t.parents(i.find),o=r.find(i.target);else var o=i.parent?t.parents(i.target):e(i.target);o.not(i.loaderClass)&&(i.content&&a.$elem.html(n),o.addClass(i.loaderClass),setTimeout(function(){i.content&&a.$elem.html(s),o.removeClass(i.loaderClass)},i.duration)),t.trigger("afterInit.ason")})},_toggle:function(){var a,i=this,t=i.config,s=i.$elem,n=e.fn.asonwidget.toggleOpenMarkup(t),l=e.fn.asonwidget.toggleCloseMarkup(t);t.content&&i.$elem.html(n),s.on("click",function(r){if(r.preventDefault(),"undefined"==typeof t.target)return void i.log("ERROR: Please define a target attribute for - TOGGLE - widget!!");if(s.trigger("beforeInit.ason"),t.find)var o=s.parents(t.find),d=o.find(t.target);else var d=t.parent?s.parents(t.target):e(t.target);if(d.hasClass(t.toggleClass)?(t.content&&s.html(n),a=t.animationOpen?t.animationOpen:"slideDown"):(t.content&&s.html(l),a=t.animationClose?t.animationClose:"slideUp"),e.Velocity)d.velocity(a,{delay:t.delay,duration:t.duration,begin:function(e){s.trigger("begin.ason")},complete:function(e){i._toggleActItemClass(d,t),s.trigger("complete.ason")}});else switch(a){case"slideDown":d.slideDown(t.duration,function(){i._toggleActItemClass(d,t),s.trigger("complete.ason")});break;case"slideUp":d.slideUp(t.duration,function(){i._toggleActItemClass(d,t),s.trigger("complete.ason")});break;case"fadeIn":d.fadeIn(t.duration,function(){i._toggleActItemClass(d,t),s.trigger("complete.ason")});break;case"fadeOut":d.fadeOut(t.duration,function(){i._toggleActItemClass(d,t),s.trigger("complete.ason")})}s.trigger("afterInit.ason")})},_scrollbar:function(){var a=this,i=a.config,t=a.$elem;return"undefined"==typeof e.fn.perfectScrollbar?void a.log("ERROR: Please include the perfect-scrollbar.min.js file!!"):(t.trigger("beforeInit.ason"),i.minHeight&&t.css({"min-height":i.minHeight}),i.maxHeight&&t.css({"max-height":i.maxHeight}),i.height&&t.css({height:i.height}),t.addClass(i.scrollbarClass).perfectScrollbar(),void t.trigger("afterInit.ason"))},_draggable:function(){var e=this,a=e.config,i=e.$elem;if("undefined"==typeof jQuery.ui)return void e.log("ERROR: Please include the jquery-ui.min.js file!!");i.trigger("beforeInit.ason");var t=a.connectWith.substring(1);i.addClass(t).sortable({items:a.items,connectWith:a.connectWith,handle:a.handle,cancel:a.cancel,placeholder:a.placeholder,opacity:a.opacity,revert:a.revert,delay:a.delay,forcePlaceholderSize:!0,forceHelperSize:!0,update:function(e,a){i.trigger("update.ason")}}),i.trigger("afterInit.ason")},_header_footer:function(i){var t,s,n,l,r=this,o=r.config,d=r.$elem;d.trigger("beforeInit.ason");var c=o.target?e(o.target):d;o.isPush&&e("body").addClass("l-slide-push"),t=i?o.baseHeader:o.baseFooter,s=i?o.header:o.footer,n=i?o.headerOpen:o.footerOpen,l=i?o.headerPush:o.footerPush,c.addClass(t),c.addClass(s),d.on("click",function(a){return a.preventDefault(),"undefined"==typeof o.target?void r.log("ERROR: Please define a target attribute for the widget!"):(d.trigger("beforeClick.ason"),c.hasClass(n)?(r._animateWidget(c,"hide",n),o.isPush&&e("body").removeClass(l)):(c.addClass(n),r._animateWidget(c,"show"),o.isPush&&e("body").addClass(l)),void d.trigger("afterClick.ason"))}),_headerFooterOnResize=function(){d.trigger("beforeResize.ason"),c.removeAttr("style"),d.trigger("afterResize.ason")},e(a).on("resize orientationchange",_headerFooterOnResize),d.trigger("afterInit.ason")},_sidebar:function(){var i,t,s,n,l,r,o,d,c,g=this,f=g.config,u=g.$elem,h="l-initial";u.trigger("beforeInit.ason");var m=f.target?e(f.target):u;i=n=this._getCurrentClass(!0),this._setBaseClass(m),(f.isPush||f.isStatic)&&e("body").addClass("l-slide-push"),m.addClass(f.isRight?"l-sidebar-right":"l-sidebar-left"),m.addClass(i).addClass(h),u.on("click",function(a){return a.preventDefault(),"undefined"==typeof f.target?void g.log("ERROR: Please define a target attribute for - SIDEBAR - widget!"):(u.trigger("beforeClick.ason"),m.removeAttr("style"),f.isSlide?(f.isStatic&&m.addClass(f.slidebarStatic),"left"==f.isSlide?(d=f.slidebarLeftOpen,c=f.slidebarLeftPush):(d=f.slidebarRightOpen,c=f.slidebarRightPush),m.hasClass(d)?(g._animateWidget(m,"hide",d),f.isPush&&e("body").removeClass(c)):(m.addClass(d),g._animateWidget(m,"show"),f.isPush&&e("body").addClass(c))):(m.hasClass(h)?(t=g._getCurrentClass(!0),t!=n&&(m.removeClass(n),m.addClass(t))):(s=g._getCurrentClass(!1),s!=l&&(m.removeClass(l),m.addClass(s))),t=g._getCurrentClass(!0),s=g._getCurrentClass(!1),t!=s&&(m.hasClass(t)?(m.removeClass(t).removeClass(h),g._animateWidget(m,"hide"),m.addClass(s),r=s):m.hasClass(s)&&(m.removeClass(s).addClass(h),g._animateWidget(m,"show"),m.addClass(t),o=t))),void u.trigger("afterClick.ason"))}),_sidebarOnResize=function(){u.trigger("beforeResize.ason"),f.isSlide?(i=g._getCurrentClass(!0),g._setBaseClass(m),n!=i&&(r!=i&&m.removeClass(r),m.removeAttr("style"),m.removeClass(n),g._animateWidget(m,"resize"),m.addClass(i),n=i)):m.hasClass(h)?(i=g._getCurrentClass(!0),g._setBaseClass(m),n!=i&&(r!=i&&m.removeClass(r),m.removeAttr("style"),m.removeClass(n),g._animateWidget(m,"resize"),m.addClass(i),n=i)):(i=g._getCurrentClass(!1),g._setBaseClass(m),l!=i&&(o!=i&&m.removeClass(o),m.removeAttr("style"),m.removeClass(l),g._animateWidget(m,"resize"),m.addClass(i),l=i)),u.trigger("afterResize.ason")},e(a).on("resize orientationchange",_sidebarOnResize),u.trigger("afterInit.ason")},_menu:function(){var a,i=this,t=i.config,s=i.$elem;s.trigger("beforeInit.ason"),s.addClass(t.navTheme),t.navSkin&&s.addClass(t.navSkin),s.find("ul").addClass(t.collapsed?t.navUlClosed:t.navUlOpen),t.isNavHidden&&!e.Velocity&&s.hide();var n=s.find("li:has(ul)");n.each(function(s,n){e(this).addClass(t.navLi),a=e(this).parentsUntil(i.elem,"ul").length,0==a&&e(this).addClass(t.navLiRoot),e(this).addClass(t.collapsed?t.navLiClosed:t.navLiOpen),e(this).children("ul").addClass("level-"+(a+1))});var l=s.find("li.active:has(ul)");if(l.each(function(a,s){t.isRootHidden&&e(this).hasClass(t.navLiRoot)&&i._isSidebarContracted(e(this))||(e(this).removeClass(t.navLiClosed).addClass(t.navLiOpen),e(this).children("ul").removeClass(t.navUlClosed).addClass(t.navUlOpen))}),n.children(":first-child").on("click",function(a){s.trigger("beforeClick.ason");var t=e(this);i._animateMenu(t,!0),s.trigger("afterClick.ason"),a.preventDefault()}),!isMobile.any&&t.navHover){var r=s.find("."+t.navLiRoot).children(":first-child");r.on("mouseenter",function(){s.trigger("beforeHover.ason");var a=e(this);return i._isSidebarContracted(a)?(i._animateMenu(a,!1),void s.trigger("afterHover.ason")):!1})}t.isNavHidden&&(s.trigger("beforeLoad.ason"),e.Velocity&&t.animInit?s.children().velocity(t.animInit,{stagger:t.animInitStagger,drag:t.animInitDrag,complete:function(){e(this).removeAttr("style")}}):s.fadeIn("slow").removeClass(t.hiddenClass),s.trigger("afterLoad.ason")),t.navScrollBar&&("undefined"==typeof e.fn.perfectScrollbar?i.log("ERROR: Please include the perfect-scrollbar.min.js file!!"):s.find(".level-1").addClass("ul-scroll").perfectScrollbar()),s.trigger("afterInit.ason")},_closeSameLevel:function(a){var i=this,t=i.config,s=a.closest("ul").children("."+t.navLiOpen).not(a.parent()).children("ul");s.addClass(t.navUlBack),e.Velocity?s.velocity({height:0},{duration:t.duration,easing:t.animEasing,display:"none",delay:100,complete:function(){s.removeClass(t.navUlBack),i._setNodeClass(s.parent(),!0)}}):s.delay(100).slideUp(t.duration,function(){s.removeClass(t.navUlBack),i._setNodeClass(s.parent(),!0)})},_animateMenu:function(a,i){var t=this,s=t.config,n=a.parent(),l=n.children("ul").first(),r=n.hasClass(s.navLiOpen);i?s.closeSameLevel&&!r&&t._closeSameLevel(a):r||t._closeSameLevel(a),l.css({height:"auto"}),!r&&e.Velocity&&s.animOpen&&l.find(" > li, li."+s.navLiOpen+" > ul > li").css({opacity:0}).velocity("stop").velocity(s.animOpen,{stagger:s.animOpenStagger,drag:s.animOpenDrag,complete:function(){e(this).removeAttr("style")}}),e.Velocity?l.velocity("stop").velocity({translateZ:0,height:r?[0,l.outerHeight()]:[l.outerHeight(),0]},{queue:!1,duration:s.duration,easing:s.animEasing,display:r?"none":"block",begin:t._setNodeClass(n,r),complete:function(){if(r||e(this).css("height","auto"),i&&s.navScroll){var a;a=t._isSidebarContracted(e(this))?e(this).parents(".root"):e(this),a.velocity("scroll",{delay:s.navScrollDelay,duration:s.navScrollDuration,offset:s.navScrollOffset,mobileHA:!1})}}}):(t._setNodeClass(n,r),r?l.slideUp(s.duration):l.slideDown(s.duration))},_setNodeClass:function(e,a){var i=this,t=i.config,s=t.navLiOpen,n=t.navLiClosed;a?e.removeClass(s).addClass(n):e.removeClass(n).addClass(s)},_animateWidget:function(i,t,s){var n,l,r=this,o=r.config;switch(t){case"show":case"hide":l=e(a).width(),o.animAll?n=o.animAll:(l>=o.sizeXl&&(n=o.animFull),l<o.sizeXl&&l>=o.sizeLg&&(n=o.animXl),l<o.sizeLg&&l>=o.sizeMd&&(n=o.animLg),l<o.sizeMd&&l>=o.sizeSm&&(n=o.animMd),l<o.sizeSm&&(n=o.animSm));break;case"resize":n=o.animResize;break;default:r.log("ERROR: No type specified !")}if(null===n)return void i.removeClass(s);switch(t){case"show":n[0]&&n[1]&&r._animateElement(i,n[0],n[1],s);break;case"hide":n[2]&&n[3]?r._animateElement(i,n[2],n[3],s):n[0]&&n[2]?r._animateElement(i,n[0],n[2],s):i.removeClass(s);break;case"resize":n[0]&&n[1]&&r._animateElement(i,n[0],n[1]);break;default:r.log("ERROR: No type specified !")}},_animateElement:function(a,i,t,s){var n=this;switch("animate"==i?a.addClass("animated"):a.removeClass("animated"),i){case"animate":a.addClass(t).one("webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend",function(){a.removeClass(t),"undefined"!=typeof s&&a.removeClass(s)});break;case"velocity":e.Velocity?a.velocity(t,{display:null,complete:function(){a.removeAttr("style"),"undefined"!=typeof s&&a.removeClass(s)}}):n.log("ERROR: Please include the velocity library!!");break;case"ason":a.addClass(t),setTimeout(function(){a.removeClass(t),"undefined"!=typeof s&&a.removeClass(s)},500);break;default:n.log("ERROR: No type specified !")}},_getCurrentClass:function(e){var a,i,t,s=this,n=s.config;return e&&n.onAll?a=s._getCurrentClassByType(n.onAll):!e&&n.toAll?a=s._getCurrentClassByType(n.toAll):(t=e?n.onFull:n.toFull,a=s._getCurrentClassByType(t),i=s._getCurrentType(e),i&&(a=s._getCurrentClassByType(i))),a},_getCurrentType:function(i){var t,s,n=this,l=n.config;return s=e(a).width(),s<l.sizeXl&&(t=i?l.onXl:l.toXl),s<l.sizeLg&&(t=i?l.onLg:l.toLg),s<l.sizeMd&&(t=i?l.onMd:l.toMd),s<l.sizeSm&&(t=i?l.onSm:l.toSm),t},_getCurrentClassByType:function(e){var a,i=this,t=i.config;switch(e){case"sidebar":a=t.sidebar,t.isSlide=!1;break;case"hidden":a=t.sidebarHidden,t.isSlide=!1;break;case"compact":a=t.isRight?t.sidebarCompactRight:t.sidebarCompactLeft,t.isSlide=!1;break;case"collapsed":a=t.isRight?t.sidebarCollapsedRight:t.sidebarCollapsedLeft,t.isSlide=!1;break;case"slidebar-left":a=t.slidebarLeft,t.isSlide="left";break;case"slidebar-right":a=t.slidebarRight,t.isSlide="right";break;default:i.log("ERROR: No type specified !")}return a},_setBaseClass:function(a){var i=this,t=i.config;t.isSlide?(a.removeClass(t.baseSidebar).removeClass(t.sidebar).removeClass(t.sidebarHidden).removeClass(t.sidebarCompactLeft).removeClass(t.sidebarCompactRight).removeClass(t.sidebarCollapsedLeft).removeClass(t.sidebarCollapsedRight),a.addClass(t.baseSlidebar)):(a.removeClass(t.baseSlidebar).removeClass(t.slidebarLeft).removeClass(t.slidebarRight).removeClass(t.slidebarLeftPush).removeClass(t.slidebarRightPush).removeClass(t.slidebarStatic).removeClass(t.slidebarLeftOpen).removeClass(t.slidebarRightOpen),e("body").removeClass(t.slidebarLeftPush).removeClass(t.slidebarRightPush),a.addClass(t.baseSidebar))},_isSidebarContracted:function(e){var a=this,i=a.config,t="."+i.sidebarCompactLeft,s="."+i.sidebarCompactRight,n="."+i.sidebarCollapsedLeft,l="."+i.sidebarCollapsedRight;return e.isChildOf(t)||e.isChildOf(s)||e.isChildOf(n)||e.isChildOf(l)?!0:!1},_toggleActItemClass:function(e,a){e.hasClass(a.toggleClass)?e.removeClass(a.toggleClass):e.addClass(a.toggleClass)},_lowerCase:function(e){return(e||"").toLowerCase()},_sanitizeData:function(e){var a,i,t={};for(var s in e)e.hasOwnProperty(s)&&/^ason[A-Z]+/.test(s)&&(a=e[s],i=s.match(/^ason(.*)/)[1].replace(/^[A-Z]/,this._lowerCase),t[i]=a);return t},_is_touch_device:function(){return"ontouchstart"in a||"onmsgesturechange"in a}},e.fn.isChildOf=function(e){return this.parents(e).length>0},e.fn.asonwidget=function(a){return this.each(function(){e.data(this,"asonWidget")||e.data(this,"asonWidget",new n(this,a))})},e.fn.asonwidget.defaults=n.prototype.defaults,e.fn.asonwidget.expandMarkup=function(e){return'<i class="'+e.iconExpand+'"></i>'},e.fn.asonwidget.contractMarkup=function(e){return'<i class="'+e.iconContract+'"></i>'},e.fn.asonwidget.deleteMarkup=function(e){return'<i class="'+e.iconDelete+'"></i>'},e.fn.asonwidget.refreshMarkup=function(e){return'<i class="'+e+'"></i>'},e.fn.asonwidget.toggleOpenMarkup=function(e){return'<i class="'+e.iconToggleOpen+'"></i>'},e.fn.asonwidget.toggleCloseMarkup=function(e){return'<i class="'+e.iconToggleClose+'"></i>'},e.fn.asonwidget.version=function(){return"Ason Widget: "+s},e.fn.asonwidget.log=function(){a.console&&console.log&&console.log("[ason] "+Array.prototype.join.call(arguments," "))},e(i).ready(function(){e(e.fn.asonwidget.defaults.autoSelector).asonwidget()})}(jQuery,window,document),function(e){var a=/iPhone/i,i=/iPod/i,t=/iPad/i,s=/(?=.*\bAndroid\b)(?=.*\bMobile\b)/i,n=/Android/i,l=/BlackBerry/i,r=/Opera Mini/i,o=/IEMobile/i,d=/(?=.*\bFirefox\b)(?=.*\bMobile\b)/i,c=RegExp("(?:Nexus 7|BNTV250|Kindle Fire|Silk|GT-P1000)","i"),g=function(e,a){return e.test(a)},f=function(e){var f=e||navigator.userAgent;this.apple={phone:g(a,f),ipod:g(i,f),tablet:g(t,f),device:g(a,f)||g(i,f)||g(t,f)},this.android={phone:g(s,f),tablet:!g(s,f)&&g(n,f),device:g(s,f)||g(n,f)},this.other={blackberry:g(l,f),opera:g(r,f),windows:g(o,f),firefox:g(d,f),device:g(l,f)||g(r,f)||g(o,f)||g(d,f)},this.seven_inch=g(c,f),this.any=this.apple.device||this.android.device||this.other.device||this.seven_inch},u=e.isMobile=new f;u.Class=f}(window);