(ns divisadero.example.app
  (:use compojure.core
        [divisadero.view-resolver :only [wrap-view-resolver]]
        [divisadero.access :only [wrap-access-control]]
        [divisadero.coffee :only [wrap-coffee]]
        [divisadero.configure :only [wrap-config]]
        [ring.middleware
         params
         keyword-params
         nested-params
         multipart-params
         cookies
         session])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [divisadero.example.fn-pages :as fn-pages]
            [divisadero.example.enlive-pages :as enlive-pages]
            [ring.util.response :as response]))

(def views
  {:login {:type :fn
           :template #'enlive-pages/admin-login}
   :success {:type :fn :template #'fn-pages/success}})

(def access-rules
  [#"/admin/login.*" #{:any}
   #"/admin/.*" #{:admin}
   #".*" #{:any}])


(def app-routes
  (routes
   (GET "/" [] fn-pages/static-home-page)
   (GET "/admin/success" [r] (assoc r :view :success))
   (GET "/admin/login" request {:view :login})
   (POST "/admin/login" [username login]
         (merge (response/redirect "/admin/success")
                {:session {:username username
                           :login login
                           :roles #{:admin}}}))
   ;; (GET "/test/user-db" [] user-db-test/test-user-db )
   (route/resources "/") ;; public pages
   (route/not-found "Page not found")))

(def app
  (-> app-routes
      (wrap-access-control access-rules (response/redirect "/admin/login"))
      (wrap-view-resolver views)
      (wrap-coffee "/js/" "src/coffee/" "resources/public/js/")
      wrap-config
      wrap-keyword-params
      wrap-nested-params
      wrap-params
      wrap-multipart-params
      wrap-session))
