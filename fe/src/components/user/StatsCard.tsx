import { StatsCardProps } from "@/type/user.type";

export default function StatsCard({
  title,
  value,
  change,
  icon,
}: StatsCardProps) {
  return (
    <div
      className="bg-white p-5 rounded-xl border border-gray-200 shadow-sm
        flex justify-between items-start"
    >
      <div>
        <p className="text-gray-500 text-sm">{title}</p>
        <h3 className="text-2xl font-semibold">{value}</h3>

        {change && <span className="text-green-500 text-sm">{change}</span>}
      </div>
      <div className="w-10 h-10 flex items-center justify-center rounded-lg bg-gray-100">
        {icon}
      </div>
    </div>
  );
}
