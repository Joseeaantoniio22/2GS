using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace CustomControl
{
    public class InfoCard : Control
    {
        static InfoCard()
        {
            // Esta línea es CRUCIAL: le dice a la app que busque el estilo en Generic.xaml
            DefaultStyleKeyProperty.OverrideMetadata(typeof(InfoCard), new FrameworkPropertyMetadata(typeof(InfoCard)));
        }

        // --- PROPIEDADES (Dependency Properties) ---

        // 1. TÍTULO (Ej: "Pacientes Hoy")
        public static readonly DependencyProperty TitleProperty =
            DependencyProperty.Register("Title", typeof(string), typeof(InfoCard), new PropertyMetadata("Título"));

        public string Title
        {
            get { return (string)GetValue(TitleProperty); }
            set { SetValue(TitleProperty, value); }
        }

        // 2. VALOR (Ej: "25")
        public static readonly DependencyProperty ValueProperty =
            DependencyProperty.Register("Value", typeof(string), typeof(InfoCard), new PropertyMetadata("0"));

        public string Value
        {
            get { return (string)GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        // 3. ICONO (Dibujo vectorial)
        public static readonly DependencyProperty IconProperty =
            DependencyProperty.Register("Icon", typeof(Geometry), typeof(InfoCard), new PropertyMetadata(null));

        public Geometry Icon
        {
            get { return (Geometry)GetValue(IconProperty); }
            set { SetValue(IconProperty, value); }
        }

        // 4. COLOR DE FONDO DEL ICONO
        public static readonly DependencyProperty IconBackgroundProperty =
            DependencyProperty.Register("IconBackground", typeof(Brush), typeof(InfoCard), new PropertyMetadata(Brushes.LightGray));

        public Brush IconBackground
        {
            get { return (Brush)GetValue(IconBackgroundProperty); }
            set { SetValue(IconBackgroundProperty, value); }
        }
    }
}