(ns divisadero.example.fn-pages)

(def static-home-page
  "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\">
<html>
<head>
  <title>OM USER</title>
  <link rel=\"stylesheet\" href=\"css/user.css\">
</head>
<body>
  <h1>User App</h1>
</body>")

(defn success [_]
   "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\">
<html>
<head>
  <title>SUCCESS!</title>
</head>
<body>
  <h1>You just accessed a protected page!</h1>
</body>")