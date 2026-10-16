(function () {
  var STORAGE_KEY = "da-pages-sidebar-collapsed";

  function ready(fn) {
    if (document.readyState !== "loading") {
      fn();
    } else {
      document.addEventListener("DOMContentLoaded", fn);
    }
  }

  ready(function () {
    var layout = document.getElementById("page-layout");
    var toggle = document.getElementById("sidebar-panel-toggle");
    var backdrop = document.getElementById("sidebar-backdrop");
    if (!layout || !toggle) {
      return;
    }

    function isMobile() {
      return window.matchMedia("(max-width: 960px)").matches;
    }

    function setCollapsed(collapsed) {
      layout.classList.toggle("sidebar-collapsed", collapsed);
      toggle.setAttribute("aria-expanded", collapsed ? "false" : "true");
      if (!isMobile()) {
        try {
          localStorage.setItem(STORAGE_KEY, collapsed ? "1" : "0");
        } catch (e) {
          /* ignore */
        }
      }
    }

    function openMobile() {
      layout.classList.add("sidebar-mobile-open");
      if (backdrop) {
        backdrop.hidden = false;
      }
      document.body.classList.add("sidebar-scroll-lock");
    }

    function closeMobile() {
      layout.classList.remove("sidebar-mobile-open");
      if (backdrop) {
        backdrop.hidden = true;
      }
      document.body.classList.remove("sidebar-scroll-lock");
    }

    toggle.addEventListener("click", function () {
      if (isMobile()) {
        if (layout.classList.contains("sidebar-mobile-open")) {
          closeMobile();
        } else {
          openMobile();
        }
        return;
      }
      setCollapsed(!layout.classList.contains("sidebar-collapsed"));
    });

    if (backdrop) {
      backdrop.addEventListener("click", closeMobile);
    }

    layout.querySelectorAll("#page-sidebar a[href^='#']").forEach(function (link) {
      link.addEventListener("click", function () {
        if (isMobile()) {
          closeMobile();
        }
      });
    });

    if (!isMobile()) {
      try {
        if (localStorage.getItem(STORAGE_KEY) === "1") {
          setCollapsed(true);
        }
      } catch (e) {
        /* ignore */
      }
    }

    window.addEventListener("resize", function () {
      if (!isMobile()) {
        closeMobile();
      }
    });
  });
})();
