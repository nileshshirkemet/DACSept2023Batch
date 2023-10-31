var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();
builder.Services.AddDbContext<DemoApp.Models.SiteDbContext>();
var app = builder.Build();
app.MapDefaultControllerRoute();
app.Run();
