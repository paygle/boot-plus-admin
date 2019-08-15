/**
 * 过滤掉年份
 */
export function DateLessYearFilter(value) {
  if (!value) return '';
  return String(value).replace(/^\d{4}-/g, '')
}