$(function () {
    var $ul = $(".ant_side").find("ul");
    $ul.on("click", "li", function () {
        var   $width = $(window).width();
        if ($width < 1200) {
            $ul.parent().removeClass("on");
            return false;
        } else {
            var hasSubMenu = $(this).find("ul").length > 0;
            var isOpen = $(this).hasClass("on");
            event.stopPropagation();
            if (hasSubMenu) {
                if (isOpen) {
                    $(this).find("ul").slideUp().parent().removeClass("on");
                } else {
                    $(this).addClass("on").children("ul").slideDown();
                }
            } else {
                $(this).click(function () {
                    return false;
                })
            }
        }
    })
});