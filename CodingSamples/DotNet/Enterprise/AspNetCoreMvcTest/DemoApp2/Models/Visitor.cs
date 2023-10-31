using System.ComponentModel.DataAnnotations;

namespace DemoApp.Models;

public class Visitor
{
    [Required]
    [MinLength(4, ErrorMessage = "Name too small")]
    public string Id { get; set; }

    [Range(0, 5)]
    public int Rating { get; set; }

    public List<Visitation> Visits { get; set; } = new();
}
